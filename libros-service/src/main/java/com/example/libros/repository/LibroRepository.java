package com.example.libros.repository;

import com.example.libros.model.Libro;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LibroRepository extends MongoRepository<Libro, String> {
  List<Libro> findByAutor(String autor);

  List<Libro> findByCategoria(String categoria);
}
