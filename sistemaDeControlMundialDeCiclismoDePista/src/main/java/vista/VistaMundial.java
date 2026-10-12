/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.util.List;
import java.util.Scanner;
import modelo.Competidor;

/**
 * Vista por consola: solo pide y muestra datos, sin lógica del negocio.
 */
public class VistaMundial {

    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n=== MUNDIAL DE CICLISMO DE PISTA - CALI ===");
        System.out.println("1. Registrar competidor");
        System.out.println("2. Listar competidores");
        System.out.println("3. Actualizar ranking (con medalla/bonificación)");
        System.out.println("4. Actualizar ranking (solo sumar puntos)");
        System.out.println("5. Ver información de atletas");
        System.out.println("0. Salir");
        return solicitarEntero("Seleccione una opción: ");
    }

    public Competidor capturarDatosCompetidor() {
        String nombre = solicitarTexto("Nombre: ");
        String pais = solicitarTexto("País: ");
        int edad = solicitarEntero("Edad: ");
        int ranking = solicitarEntero("Ranking inicial: ");
        double estatura = solicitarDecimal("Estatura (m): ");
        double peso = solicitarDecimal("Peso (kg): ");
        return new Competidor(nombre, pais, edad, ranking, estatura, peso);
    }

    public void mostrarListaCompetidores(List<Competidor> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay competidores registrados.");
            return;
        }
        for (Competidor c : lista) {
            System.out.println(c.informacionAtleta());
        }
    }

    // ---- Métodos auxiliares (no están en el UML) ----

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String solicitarTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    /** Repite la pregunta hasta que el usuario escriba un entero válido. */
    public int solicitarEntero(String mensaje) {
        while (true) {
            try {
                return Integer.parseInt(solicitarTexto(mensaje));
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número entero válido.");
            }
        }
    }

    public double solicitarDecimal(String mensaje) {
        while (true) {
            try {
                return Double.parseDouble(solicitarTexto(mensaje).replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        }
    }

    public boolean solicitarSiNo(String mensaje) {
        String r = solicitarTexto(mensaje + " (s/n): ");
        return r.equalsIgnoreCase("s");
    }
}
