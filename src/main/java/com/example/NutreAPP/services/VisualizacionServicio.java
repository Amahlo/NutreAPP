package com.example.NutreAPP.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.NutreAPP.models.Visualizacion;
import com.example.NutreAPP.repositories.IVisualizacionRepositorio;

public class VisualizacionServicio {

    @Autowired
    private IVisualizacionRepositorio repositorio;

    public Visualizacion guardar(Visualizacion datos) {
        return this.repositorio.save(datos);
    }

}
