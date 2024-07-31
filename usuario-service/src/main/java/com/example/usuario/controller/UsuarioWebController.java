package com.example.usuario.controller;

import com.example.usuario.model.Usuario;
import com.example.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioWebController {

  @Autowired
  private UsuarioService usuarioService;

  @GetMapping
  public String obtenerUsuarios(Model model) {
    model.addAttribute("usuarios", usuarioService.obtenerTodosLosUsuarios());
    return "usuarios";
  }

  @GetMapping("/nuevo")
  public String mostrarFormularioDeNuevoUsuario(Model model) {
    model.addAttribute("usuario", new Usuario());
    return "nuevo_usuario";
  }

  @GetMapping("/edit/{id}")
  public String mostrarFormularioDeEditarUsuario(@PathVariable String id, Model model) {
    Usuario usuario = usuarioService.obtenerUsuarioPorId(id).orElse(null);
    model.addAttribute("usuario", usuario);
    return "nuevo_usuario";
  }

  @PostMapping
  public String guardarUsuario(@ModelAttribute Usuario usuario) {
    usuarioService.registrarUsuario(usuario);
    return "redirect:http://localhost:8080/usuarios";
  }

  @GetMapping("/delete/{id}")
  public String eliminarUsuario(@PathVariable String id) {
    usuarioService.eliminarUsuario(id);
    return "redirect:http://localhost:8080/usuarios";
  }
}
