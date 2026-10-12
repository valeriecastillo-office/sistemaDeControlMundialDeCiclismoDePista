/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


public class Competidor extends Atleta {

   
    private static final int PUNTOS_CON_MEDALLA = 50;
    private static final int PUNTOS_SIN_MEDALLA = 25;
    private static final int UMBRAL_BONIFICACION = 50;
    private static final int VALOR_BONIFICACION = 25;


    private int ranking;
    private double estatura;
    private double peso;

    public Competidor(String nombre, String pais, int edad,
                      int ranking, double estatura, double peso) {
        super(nombre, pais, edad); 
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

   
    @Override
    public String informacionAtleta() {
        return super.informacionAtleta()
                + " | Ranking: " + ranking
                + " | Estatura: " + estatura + " m"
                + " | Peso: " + peso + " kg";
    }

  
    public int actualizarRanking(int puntosObtenidos) {
      
        if (puntosObtenidos < 0) {
            return ranking; }
        ranking = ranking + puntosObtenidos;
        return ranking;
    }

  
    public int actualizarRanking(int puntosObtenidos, boolean ganoMedalla) {
        
        int bonificacion;

        if (ganoMedalla) {
            
            puntosObtenidos = puntosObtenidos + PUNTOS_CON_MEDALLA;

            if (puntosObtenidos >= UMBRAL_BONIFICACION) {
                bonificacion = VALOR_BONIFICACION; 
            } else {
                bonificacion = 0;                 
            }
        } else {
            
            puntosObtenidos = puntosObtenidos + PUNTOS_SIN_MEDALLA;

           
            if (puntosObtenidos >= UMBRAL_BONIFICACION) {
                bonificacion = VALOR_BONIFICACION; 
            } else {
                bonificacion = 0;                  
            }
        }

     
        int puntosAcumulados = this.ranking;

      
        this.ranking = puntosObtenidos + bonificacion + puntosAcumulados;


        return this.ranking;
    }
}
