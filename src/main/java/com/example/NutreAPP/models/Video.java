package com.example.NutreAPP.models;

import java.util.UUID;

import com.example.NutreAPP.models.helpers.Categoria;

public class Video {
    private UUID id;
    private String titulo;
    private String descripcion;
    private String URL;
    private Categoria categoria;

    public Video() {
    }

    public Video(UUID id, String titulo, String descripcion, String uRL, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        URL = uRL;
        this.categoria = categoria;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public String getURL() {
        return URL;
    }

    public void setURL(String uRL) {
        URL = uRL;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
