package com.example.prestamos.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "prestamos")
public class Prestamo {
  private String id;
  private String fechaPrestamo; // Cambiado a String
  private String fechaEntrega; // Cambiado a String
  private boolean entregado;
  private String idUsuario;
  private String idLibro;

  private String username;
  private String tituloLibro;

  // Getters y setters
  public String getUserName() {
    return username;
  }

  public void setUserName(String username) {
    this.username = username;
  }

  public String getTituloLibro() {
    return tituloLibro;
  }

  public void setTituloLibro(String tituloLibro) {
    this.tituloLibro = tituloLibro;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public String getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(String idUsuario) {
    this.idUsuario = idUsuario;
  }

  public String getIdLibro() {
    return idLibro;
  }

  public void setIdLibro(String idLibro) {
    this.idLibro = idLibro;
  }
}
