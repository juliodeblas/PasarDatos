package com.example.pasardatos.utils;

import java.io.Serializable;

public class Persona implements Serializable {

    String nombre, apellidos;
    int telefono;

    public Persona(String nombre, String apellidos, int telefono) {
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }


}
