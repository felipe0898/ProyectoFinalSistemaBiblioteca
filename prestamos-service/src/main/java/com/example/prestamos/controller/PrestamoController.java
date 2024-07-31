package com.example.prestamos.controller;

import com.example.prestamos.model.Prestamo;
import com.example.prestamos.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

  @Autowired
  private PrestamoService prestamoService;

  @PostMapping
  public Prestamo crearPrestamo(@RequestBody Prestamo prestamo) {
    return prestamoService.guardarPrestamo(prestamo);
  }

  @GetMapping
  public List<Prestamo> obtenerTodosLosPrestamos() {
    return prestamoService.obtenerTodosLosPrestamos();
  }

  @GetMapping("/{id}")
  public Prestamo obtenerPrestamoPorId(@PathVariable String id) {
    return prestamoService.obtenerPrestamoPorId(id).orElse(null);
  }

  @DeleteMapping("/{id}")
  public void eliminarPrestamo(@PathVariable String id) {
    prestamoService.eliminarPrestamo(id);
  }
}
