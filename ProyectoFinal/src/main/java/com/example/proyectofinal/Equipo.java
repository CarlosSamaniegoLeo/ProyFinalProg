package com.example.proyectofinal;

public class Equipo {
    private String nombre;
    private String ciudad;

    private int victorias, derrotas, empates, goles_marcados, goles_encajados, puntos;

    public Equipo(String nombre, String ciudad, int victorias, int derrotas, int empates, int goles_marcados, int goles_encajados, int puntos) {

        this.nombre = nombre;
        this.ciudad = ciudad;
        this.victorias = victorias;
        this.derrotas = derrotas;
        this.empates = empates;
        this.goles_marcados = goles_marcados;
        this.goles_encajados = goles_encajados;
        this.puntos = puntos;
    }



    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public int getGoles_marcados() {
        return goles_marcados;
    }

    public void setGoles_marcados(int goles_marcados) {
        this.goles_marcados = goles_marcados;
    }

    public int getGoles_encajados() {
        return goles_encajados;
    }

    public void setGoles_encajados(int goles_encajados) {
        this.goles_encajados = goles_encajados;
    }

    public void mostrarEquipo(){
        System.out.println("Equipo "+this.nombre+" de la ciudad "+this.ciudad + " tiene " + this.victorias + " victorias, " +
                this.derrotas + " derrotas y " + this.empates + " con un puntaje total de " + this.puntos + " puntos" +
                " y " + this.goles_marcados + " goles marcados y " + this.goles_encajados + " goles encajados");
    }
}
