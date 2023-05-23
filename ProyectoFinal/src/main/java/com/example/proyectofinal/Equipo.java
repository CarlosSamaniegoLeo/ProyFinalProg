package com.example.proyectofinal;

public class Equipo {
    private String nombre;
    private String ciudad;

    private int victorias, derrotas, empates, goles_marcados, goles_encajados, puntuacion, posicion;

    public Equipo(String nombre, int victorias, int derrotas, int empates, int goles_marcados, int goles_encajados, int puntuacion, int posicion) {

        this.nombre = nombre;
        this.ciudad = ciudad;
        this.victorias = victorias;
        this.derrotas = derrotas;
        this.empates = empates;
        this.goles_marcados = goles_marcados;
        this.goles_encajados = goles_encajados;
        this.puntuacion = puntuacion;
        this.posicion = posicion;
    }


    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
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
                this.derrotas + " derrotas y " + this.empates + " con un puntaje total de " + this.puntuacion + " puntos" +
                " y " + this.goles_marcados + " goles marcados y " + this.goles_encajados + " goles encajados");
    }
}
