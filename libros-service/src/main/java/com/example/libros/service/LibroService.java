package com.example.libros.service;

import com.example.libros.model.Libro;
import com.example.libros.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
  @Autowired
  private LibroRepository libroRepository;

  public Libro guardarLibro(Libro libro) {
    return libroRepository.save(libro);
  }

  public List<Libro> obtenerTodosLosLibros() {
    return libroRepository.findAll();
  }

  public Optional<Libro> obtenerLibroPorId(String id) {
    return libroRepository.findById(id);
  }

  public List<Libro> buscarLibrosPorAutor(String autor) {
    return libroRepository.findByAutor(autor);
  }

  public List<Libro> buscarLibrosPorCategoria(String categoria) {
    return libroRepository.findByCategoria(categoria);
  }

  public Libro actualizarLibro(String id, Libro libroActualizado) {
    Optional<Libro> libro = libroRepository.findById(id);
    if (libro.isPresent()) {
      Libro libroExistente = libro.get();
      libroExistente.setTitulo(libroActualizado.getTitulo());
      libroExistente.setAutor(libroActualizado.getAutor());
      libroExistente.setIsbn(libroActualizado.getIsbn());
      libroExistente.setCategoria(libroActualizado.getCategoria());
      libroExistente.setFechaPublicacion(libroActualizado.getFechaPublicacion());
      return libroRepository.save(libroExistente);
    } else {
      return null;
    }
  }

  public void eliminarLibro(String id) {
    libroRepository.deleteById(id);
  }
}
