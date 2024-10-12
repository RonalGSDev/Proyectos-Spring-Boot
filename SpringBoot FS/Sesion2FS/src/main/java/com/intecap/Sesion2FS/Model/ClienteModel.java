package com.intecap.Sesion2FS.Model;

public class ClienteModel {

    private String dpi;
    private  String nombres;
    private String apellidos;
    private int telefono;


    //constructor
    public ClienteModel(String dpi, String nombres, String apellidos, int telefono){
        this.dpi = dpi;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
    }

    public ClienteModel() {
    }

    //metodo GET dpi
    public String getDpi(){
        return this.dpi;
    }

    //Metodo SET dpi
    public  void setDpi(String dpi){
        this.dpi = dpi;
    }

    //Metodo GET nombres
    public  String getNombres(){
        return this.nombres;
    }

    //Metodo SET nombres
    public  void setNombres(String nombres){
        this.nombres = nombres;
    }

    //Metodo GET apellidos
    public  String getApellidos(){
        return this.apellidos;
    }

    //Metodo SET apellidos
    public  void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }

    //GET telefono
    public  int getTelefono(){
        return  this.telefono;
    }

    //SET telefono
    public  void  setTelefono(int telefono){
        this.telefono = telefono;
    }


}
