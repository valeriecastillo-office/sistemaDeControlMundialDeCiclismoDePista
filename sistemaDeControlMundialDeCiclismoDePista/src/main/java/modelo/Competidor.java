/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Clase hija: un atleta que compite en el Mundial y tiene ranking.
 */
public class Competidor extends Atleta {

    // Constantes para evitar "números mágicos" en el cálculo del ranking
    private static final int PUNTOS_CON_MEDALLA = 50;
    private static final int PUNTOS_SIN_MEDALLA = 25;
    private static final int UMBRAL_BONIFICACION = 50;
    private static final int VALOR_BONIFICACION = 25;

    // Atributos propios según el UML
    private int ranking;
    private double estatura;
    private double peso;

    public Competidor(String nombre, String pais, int edad,
                      int ranking, double estatura, double peso) {
        super(nombre, pais, edad); // inicializa la parte heredada
        this.ranking = ranking;
        this.estatura = estatura;
        this.peso = peso;
    }

    public int getRanking() { return ranking; }
    public void setRanking(int ranking) { this.ranking = ranking; }

    public double getEstatura() { return estatura; }
    public void setEstatura(double estatura) { this.estatura = estatura; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    /** Sobreescritura: reutiliza el texto del padre y agrega los datos propios. */
    @Override
    public String informacionAtleta() {
        return super.informacionAtleta()
                + " | Ranking: " + ranking
                + " | Estatura: " + estatura + " m"
                + " | Peso: " + peso + " kg";
    }

    /**
     * SOBRECARGA 1: versión simple. Solo suma los puntos al ranking actual.
     * @return el nuevo valor del ranking
     */
    public int actualizarRanking(int puntosObtenidos) {
        // Validación: no se aceptan puntos negativos
        if (puntosObtenidos < 0) {
            return ranking; // no se modifica el ranking
        }
        ranking = ranking + puntosObtenidos;
        return ranking;
    }

    /**
     * SOBRECARGA 2: sigue paso a paso el diagrama de flujo, usando
     * condicionales anidados (un if/else dentro de otro if/else).
     * @return el nuevo valor del ranking
     */
    public int actualizarRanking(int puntosObtenidos, boolean ganoMedalla) {
        // Paso 1: los puntos y si ganó medalla llegan como parámetros
        int bonificacion;

        // Paso 2: ¿el competidor ganó medalla?
        if (ganoMedalla) {
            // Sí: se suman 50 puntos
            puntosObtenidos = puntosObtenidos + PUNTOS_CON_MEDALLA;

            // Paso 3 (anidado): ¿puntos obtenidos >= 50?
            if (puntosObtenidos >= UMBRAL_BONIFICACION) {
                bonificacion = VALOR_BONIFICACION; // sí: +25 de bonificación
            } else {
                bonificacion = 0;                  // no: sin bonificación
            }
        } else {
            // No: se suman 25 puntos
            puntosObtenidos = puntosObtenidos + PUNTOS_SIN_MEDALLA;

            // Paso 3 (anidado): ¿puntos obtenidos >= 50?
            if (puntosObtenidos >= UMBRAL_BONIFICACION) {
                bonificacion = VALOR_BONIFICACION; // sí: +25 de bonificación
            } else {
                bonificacion = 0;                  // no: sin bonificación
            }
        }

        // Paso 4: guardar el ranking previo (puntos que ya tenía)
        int puntosAcumulados = this.ranking;

        // Paso 5: ranking = puntos obtenidos + bonificación + puntos acumulados
        this.ranking = puntosObtenidos + bonificacion + puntosAcumulados;

        // Paso 6: retornar el valor
        return this.ranking;
    }
}
