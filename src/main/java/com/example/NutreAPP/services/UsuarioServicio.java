package com.example.NutreAPP.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.NutreAPP.models.Usuario;
import com.example.NutreAPP.repositories.IUsuarioRepositories;

@Service
public class UsuarioServicio {
    // Para cocinar necesito las recetas
    // Para programar los servicios necesito los repositorios
    // Inyeccion de dependedicas
    @Autowired
    private IUsuarioRepositories repositorio;

    // Metodo para guardar un usuario
    public Usuario guardar(Usuario datos) {
        return this.repositorio.save(datos);
    }

    // metodo para buscar por id
    public Usuario buscarPorId(UUID id) {
        Optional<Usuario> usuarioBuscado = this.repositorio.findById(id);
        if (!usuarioBuscado.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id no encontrado");

        } else {
            return usuarioBuscado.get();
        }
    }

    // metodo para buscar todos
    public List<Usuario> buscarTodos() {
        return this.repositorio.findAll();
    }

    // metodo para modificar/actualizar
    public Usuario modificar(UUID id, Usuario datos) {
        Optional<Usuario> usuarioBuscado = this.repositorio.findById(id);
        if (!usuarioBuscado.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id no encontrado");

        } else {
            // 1. precargar la info que existe actualmente en DB
            Usuario usuarioEncontrado = usuarioBuscado.get();

            // 2. Espacio para modificar solo las propiedades permitidas
            usuarioEncontrado.setNombre(datos.getNombre());
            usuarioEncontrado.setRol(datos.getRol());

            // 3. Espacio para volver a guardar el usuario que se acaba de actualizar
            return this.repositorio.save(usuarioEncontrado);
        }
    }

    // metodo para eliminar
    public boolean eliminar(UUID id) {
        Optional<Usuario> usuarioBuscado = this.repositorio.findById(id);
        if (!usuarioBuscado.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id no encontrado");

        } else {
            this.repositorio.deleteById(id);
            return true;
        }
    }

    // metodo para buscar por departamento y rol
    // metodo para buscar por correo
    // metodo para buscar por rol
    // metodo para verificar correo

}
