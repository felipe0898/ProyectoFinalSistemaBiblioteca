package com.example.prestamos.model;

public class PrestamoView {
  private String id;
  private String username;
  private String libroTitulo;
  private String fechaPrestamo;
  private String fechaEntrega;
  private boolean entregado;

  // Constructor
  public PrestamoView(String id, String username, String libroTitulo, String fechaPrestamo, String fechaEntrega,
      boolean entregado) {
    this.id = id;
    this.username = username;
    this.libroTitulo = libroTitulo;
    this.fechaPrestamo = fechaPrestamo;
    this.fechaEntrega = fechaEntrega;
    this.entregado = entregado;
  }

  // Getters y Setters
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getLibroTitulo() {
    return libroTitulo;
  }

  public void setLibroTitulo(String libroTitulo) {
    this.libroTitulo = libroTitulo;
  }

  public String getFechaPrestamo() {
    return fechaPrestamo;
  }

  public void setFechaPrestamo(String fechaPrestamo) {
    this.fechaPrestamo = fechaPrestamo;
  }

  public String getFechaEntrega() {
    return fechaEntrega;
  }

  public void setFechaEntrega(String fechaEntrega) {
    this.fechaEntrega = fechaEntrega;
  }

  public boolean isEntregado() {
    return entregado;
  }

  public void setEntregado(boolean entregado) {
    this.entregado = entregado;
  }
}
