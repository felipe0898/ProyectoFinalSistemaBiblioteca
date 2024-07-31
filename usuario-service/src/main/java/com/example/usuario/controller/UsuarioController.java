package com.example.usuario.controller;

import com.example.usuario.model.Usuario;
import com.example.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario registrarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.registrarUsuario(usuario);
    }

    @GetMapping
    public List<Usuario> obtenerUsuarios() {
        return usuarioService.obtenerTodosLosUsuarios();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> obtenerUsuarioPorId(@PathVariable String id) {
        return usuarioService.obtenerUsuarioPorId(id);
    }

    @GetMapping("/username/{username}")
    public Usuario obtenerUsuarioPorUsername(@PathVariable String username) {
        return usuarioService.obtenerUsuarioPorUsername(username);
    }

    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable String id, @RequestBody Usuario usuario) {
        return usuarioService.actualizarUsuario(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable String id) {
        usuarioService.eliminarUsuario(id);
    }
}
