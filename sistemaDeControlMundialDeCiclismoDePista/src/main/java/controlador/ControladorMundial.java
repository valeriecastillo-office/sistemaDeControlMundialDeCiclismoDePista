/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Competidor;
import vista.VistaMundial;


public class ControladorMundial {

    private List<Competidor> competidores;
    private VistaMundial vista;

    public ControladorMundial(VistaMundial vista) {
        this.vista = vista;
        this.competidores = new ArrayList<>();
    }


    public String informacionAtleta() {
        if (competidores.isEmpty()) {
            return "No hay competidores registrados.";
        }
        String texto = "";
        for (Competidor c : competidores) {
            texto = texto + c.informacionAtleta() + "\n";
        }
        return texto;
    }

    public void agregarCompetidor(Competidor competidor) {
        competidores.add(competidor);
    }


    public Competidor buscarCompetidor(String nombre) {
        for (Competidor c : competidores) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }

    
    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    agregarCompetidor(vista.capturarDatosCompetidor());
                    vista.mostrarMensaje("Competidor registrado.");
                    break;
                case 2:
                    vista.mostrarListaCompetidores(competidores);
                    break;
                case 3:
                    actualizarRankingDeCompetidor(true);
                    break;
                case 4:
                    actualizarRankingDeCompetidor(false);
                    break;
                case 5:
                    vista.mostrarMensaje(informacionAtleta());
                    break;
                case 0:
                    vista.mostrarMensaje("¡Hasta pronto!");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void actualizarRankingDeCompetidor(boolean conMedallaYBonificacion) {
        Competidor c = buscarCompetidor(vista.solicitarTexto("Nombre del competidor: "));
        if (c == null) {
            vista.mostrarMensaje("Competidor no encontrado.");
            return;
        }
        int puntos = vista.solicitarEntero("Puntos obtenidos: ");
        if (puntos < 0) {
            vista.mostrarMensaje("Los puntos no pueden ser negativos.");
            return;
        }
        int nuevoRanking;
        if (conMedallaYBonificacion) {
            boolean medalla = vista.solicitarSiNo("¿Ganó medalla?");
            nuevoRanking = c.actualizarRanking(puntos, medalla);
        } else {
            nuevoRanking = c.actualizarRanking(puntos);
        }
        vista.mostrarMensaje("Nuevo ranking de " + c.getNombre() + ": " + nuevoRanking);
    }
}
