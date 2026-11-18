package com.example.NutreAPP.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.NutreAPP.models.Video;
import com.example.NutreAPP.repositories.IVideoRepositorio;

public class VideoServicio {

    @Autowired
    private IVideoRepositorio repositorio;

    public Video guardar(Video datos) {
        return this.repositorio.save(datos);
    }

    public Video buscarPorId(UUID id) {
        Optional<Video> videoBuscado = this.repositorio.findById(id);
        if (!videoBuscado.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id no encontrado");

        } else {
            return videoBuscado.get();
        }
    }

    public List<Video> buscarTodos() {
        return this.repositorio.findAll();
    }

    public Video modificar(UUID id, Video datos) {
        Optional<Video> videoBuscado = this.repositorio.findById(id);
        if (!videoBuscado.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id no encontrado");

        } else {
            Video videoEncontrado = videoBuscado.get();

            videoEncontrado.setTitulo(datos.getTitulo());
            videoEncontrado.setCategoria(datos.getCategoria());
            videoEncontrado.setUrl(datos.getUrl());

            return this.repositorio.save(videoEncontrado);
        }
    }

    public boolean eliminar(UUID id) {
        Optional<Video> videoBuscado = this.repositorio.findById(id);
        if (!videoBuscado.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id no encontrado");

        } else {
            this.repositorio.deleteById(id);
            return true;
        }
    }
}
