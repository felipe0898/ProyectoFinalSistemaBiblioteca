package com.example.libros.controller;

import com.example.libros.model.Libro;
import com.example.libros.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
public class LibroRestController {

  @Autowired
  private LibroService libroService;

  @PostMapping
  public Libro crearLibro(@RequestBody Libro libro) {
    return libroService.guardarLibro(libro);
  }

  @GetMapping
  public List<Libro> obtenerLibros() {
    return libroService.obtenerTodosLosLibros();
  }

  @GetMapping("/{id}")
  public Optional<Libro> obtenerLibroPorId(@PathVariable String id) {
    return libroService.obtenerLibroPorId(id);
  }

  @GetMapping("/autor/{autor}")
  public List<Libro> buscarLibrosPorAutor(@PathVariable String autor) {
    return libroService.buscarLibrosPorAutor(autor);
  }

  @GetMapping("/categoria/{categoria}")
  public List<Libro> buscarLibrosPorCategoria(@PathVariable String categoria) {
    return libroService.buscarLibrosPorCategoria(categoria);
  }

  @PutMapping("/{id}")
  public Libro actualizarLibro(@PathVariable String id, @RequestBody Libro libro) {
    return libroService.actualizarLibro(id, libro);
  }

  @DeleteMapping("/{id}")
  public void eliminarLibro(@PathVariable String id) {
    libroService.eliminarLibro(id);
  }
}
