package com.intecap.Sesion2FS.Model;

public class UsuarioModel {

    private String nombre;
    private String direccion;
    private int numTelefono;
    private String correoElectronico;

    //constructor
    public UsuarioModel(String nombre, String direccion, int numTelefono, String correoElectronico) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.numTelefono = numTelefono;
        this.correoElectronico = correoElectronico;
    }

    public  UsuarioModel(String nombre, int numTelefono){
        this.nombre = nombre;
        this.numTelefono = numTelefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(int numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}


                                                    