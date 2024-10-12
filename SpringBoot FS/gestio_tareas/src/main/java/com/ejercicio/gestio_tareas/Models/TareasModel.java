package com.ejercicio.gestio_tareas.Models;

public class TareasModel {
    private String code; // Código de la tarea
    private String titulo; // Título de la tarea
    private String descripcion; // Descripción de la tarea

    // Constructor
    public TareasModel() {}

    public TareasModel(String code, String titulo, String descripcion) {
        this.code = code;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
