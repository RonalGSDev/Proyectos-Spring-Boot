package com.intecap.Sesion2FS.Model;

public class ProductoModel {

    private int id;
    private String nombre;
    private String color;
    private  double cantidad;

    public ProductoModel(int id, String nombre, String color, double cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.color = color;
        this.cantidad = cantidad;
    }

    public ProductoModel() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
