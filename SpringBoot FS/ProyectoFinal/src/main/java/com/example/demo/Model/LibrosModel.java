package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "libro")

public class LibrosModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;
    private String autor;
    private int anio_publicado;
    
    public LibrosModel(int id, String titulo, String autor, int anio_publicado) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anio_publicado = anio_publicado;
    }

    public LibrosModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnio_publicado() {
        return anio_publicado;
    }

    public void setAnio_publicado(int anio_publicado) {
        this.anio_publicado = anio_publicado;
    }

}
