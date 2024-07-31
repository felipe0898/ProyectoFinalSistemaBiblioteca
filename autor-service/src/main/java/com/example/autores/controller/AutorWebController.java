package com.example.autores.controller;

import com.example.autores.model.Autor;
import com.example.autores.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/autores")
public class AutorWebController {
  @Autowired
  private AutorService autorService;

  @GetMapping
  public String listarAutores(Model model) {
    model.addAttribute("autores", autorService.obtenerTodosLosAutores());
    return "autores";
  }

  @GetMapping("/nuevo")
  public String mostrarFormularioDeNuevoAutor(Model model) {
    model.addAttribute("autor", new Autor());
    return "nuevo_autor";
  }

  @PostMapping
  public String guardarAutor(@ModelAttribute Autor autor) {
    autorService.guardarAutor(autor);
    return "redirect:http://localhost:8080/autores";
  }

  @GetMapping("/edit/{id}")
  public String mostrarFormularioDeEditarAutor(@PathVariable String id, Model model) {
    Autor autor = autorService.obtenerAutorPorId(id).orElse(null);
    model.addAttribute("autor", autor);
    return "nuevo_autor";
  }

  @GetMapping("/delete/{id}")
  public String eliminarAutor(@PathVariable String id) {
    autorService.eliminarAutor(id);
    return "redirect:http://localhost:8080/autores";
  }
}
