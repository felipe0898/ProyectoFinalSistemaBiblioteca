package com.example.libros.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "libros")
public class Libro {
  @Id
  private String id;
  @Indexed
  private String titulo;
  @Indexed
  private String autor;
  private String isbn;
  private String categoria;
  private String fechaPublicacion;

  // Getters y Setters
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

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public String getFechaPublicacion() {
    return fechaPublicacion;
  }

  public void setFechaPublicacion(String fechaPublicacion) {
    this.fechaPublicacion = fechaPublicacion;
  }
}
