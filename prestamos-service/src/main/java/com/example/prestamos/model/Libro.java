package com.example.prestamos.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "libros")
public class Libro {

  private String id;
  private String titulo;

  // Getters y setters

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }
}
