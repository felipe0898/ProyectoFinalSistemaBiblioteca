package com.example.autores.controller;

import com.example.autores.model.Autor;
import com.example.autores.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/autores")
public class AutorController {
  @Autowired
  private AutorService autorService;

  @PostMapping
  public Autor crearAutor(@RequestBody Autor autor) {
    return autorService.guardarAutor(autor);
  }

  @GetMapping
  public List<Autor> obtenerAutores() {
    return autorService.obtenerTodosLosAutores();
  }

  @GetMapping("/{id}")
  public Optional<Autor> obtenerAutorPorId(@PathVariable String id) {
    return autorService.obtenerAutorPorId(id);
  }

  @PutMapping("/{id}")
  public Autor actualizarAutor(@PathVariable String id, @RequestBody Autor autor) {
    return autorService.actualizarAutor(id, autor);
  }

  @DeleteMapping("/{id}")
  public void eliminarAutor(@PathVariable String id) {
    autorService.eliminarAutor(id);
  }
}
