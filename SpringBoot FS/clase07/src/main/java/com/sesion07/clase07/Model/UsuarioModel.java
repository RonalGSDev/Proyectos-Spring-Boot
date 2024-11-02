package com.sesion07.clase07.Model;

public class UsuarioModel {
    private long id;
    private String nombres;
    private String correo;
    
    public UsuarioModel() {
    }
    public UsuarioModel(long id, String nombres, String correo) {
        this.id = id;
        this.nombres = nombres;
        this.correo = correo;
    }
    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getNombres() {return nombres;}

    public void setNombres(String nombres) {this.nombres = nombres;}

    public String getCorreo() {return correo;}

    public void setCorreo(String correo) {this.correo = correo;}

}
