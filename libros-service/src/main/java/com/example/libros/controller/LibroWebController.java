package com.example.libros.controller;

import com.example.libros.model.Libro;
import com.example.libros.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/libros")
public class LibroWebController {

  @Autowired
  private LibroService libroService;

  @GetMapping
  public String getAllLibros(Model model) {
    List<Libro> libros = libroService.obtenerTodosLosLibros();
    model.addAttribute("libros", libros);
    return "libros";
  }

  @GetMapping("/nuevo")
  public String crearLibroForm(Model model) {
    model.addAttribute("libro", new Libro());
    return "nuevo_libro";
  }

  @PostMapping
  public String crearLibro(Libro libro) {
    libroService.guardarLibro(libro);
    return "redirect:http://localhost:8080/libros";
  }

  @GetMapping("/edit/{id}")
  public String editarLibroForm(@PathVariable String id, Model model) {
    Libro libro = libroService.obtenerLibroPorId(id).orElse(null);
    if (libro != null) {
      model.addAttribute("libro", libro);
      return "nuevo_libro";
    } else {
      return "redirect:/libros";
    }
  }

  @PostMapping("/save")
  public String guardarLibro(@ModelAttribute Libro libro) {
    if (libro.getId() != null && libroService.obtenerLibroPorId(libro.getId()).isPresent()) {
      libroService.actualizarLibro(libro.getId(), libro);
    } else {
      libroService.guardarLibro(libro);
    }
    return "redirect:/libros";
  }

  @GetMapping("/delete/{id}")
  public String eliminarLibro(@PathVariable String id) {
    libroService.eliminarLibro(id);
    return "redirect:http://localhost:8080/libros";
  }
}
