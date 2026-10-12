/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Atleta {

    private String nombre;
    private String pais;
    private int edad;

    public Atleta(String nombre, String pais, int edad) {
        this.nombre = nombre;
        this.pais = pais;
        this.edad = edad;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

   
    public String informacionAtleta() {
        return "Nombre: " + nombre + " | País: " + pais + " | Edad: " + edad;
    }
}
