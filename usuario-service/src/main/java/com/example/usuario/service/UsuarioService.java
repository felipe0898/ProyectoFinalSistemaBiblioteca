package com.example.usuario.service;

import com.example.usuario.model.Usuario;
import com.example.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

  @Autowired
  private UsuarioRepository usuarioRepository;

  public Usuario registrarUsuario(Usuario usuario) {
    return usuarioRepository.save(usuario);
  }

  public List<Usuario> obtenerTodosLosUsuarios() {
    return usuarioRepository.findAll();
  }

  public Optional<Usuario> obtenerUsuarioPorId(String id) {
    return usuarioRepository.findById(id);
  }

  public Usuario obtenerUsuarioPorUsername(String username) {
    return usuarioRepository.findByUsername(username);
  }

  public Usuario actualizarUsuario(String id, Usuario usuarioActualizado) {
    Optional<Usuario> usuario = usuarioRepository.findById(id);
    if (usuario.isPresent()) {
      Usuario usuarioExistente = usuario.get();
      usuarioExistente.setUsername(usuarioActualizado.getUsername());
      usuarioExistente.setPassword(usuarioActualizado.getPassword());
      usuarioExistente.setEmail(usuarioActualizado.getEmail());
      return usuarioRepository.save(usuarioExistente);
    } else {
      return null;
    }
  }

  public void eliminarUsuario(String id) {
    usuarioRepository.deleteById(id);
  }
}
