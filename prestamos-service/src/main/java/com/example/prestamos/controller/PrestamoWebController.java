package com.example.prestamos.controller;

import com.example.prestamos.model.Libro;
import com.example.prestamos.model.Prestamo;
import com.example.prestamos.model.Usuario;
import com.example.prestamos.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.example.prestamos.model.PrestamoView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/prestamos")
public class PrestamoWebController {

  @Autowired
  private PrestamoService prestamoService;

  @Autowired
  private RestTemplate restTemplate;

  private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  @GetMapping
  public String getAllPrestamos(Model model) {
    List<Prestamo> prestamos = prestamoService.obtenerTodosLosPrestamos();

    // Convertir los IDs a valores legibles
    List<PrestamoView> prestamosView = prestamos.stream().map(prestamo -> {
      Usuario usuario = prestamoService.obtenerUsuarioPorId(prestamo.getIdUsuario());
      Libro libro = prestamoService.obtenerLibroPorId(prestamo.getIdLibro());

      return new PrestamoView(
          prestamo.getId(),
          usuario != null ? usuario.getUsername() : "Desconocido",
          libro != null ? libro.getTitulo() : "Desconocido",
          prestamo.getFechaPrestamo(),
          prestamo.getFechaEntrega(),
          prestamo.isEntregado());
    }).collect(Collectors.toList());

    model.addAttribute("prestamos", prestamosView);
    return "prestamos";
  }

  @GetMapping("/nuevo")
  public String crearPrestamoForm(Model model) {
    Prestamo prestamo = new Prestamo();
    model.addAttribute("prestamo", prestamo);
    model.addAttribute("usuarios", obtenerUsuarios());
    model.addAttribute("libros", obtenerLibros());
    return "nuevo_prestamo";
  }

  @PostMapping("/guardar")
  public String guardarPrestamo(@ModelAttribute Prestamo prestamo) {
    if (prestamo.getId() == null) {
      LocalDate fechaActual = LocalDate.now();
      prestamo.setFechaPrestamo(fechaActual.format(formatter));
      prestamo.setFechaEntrega(fechaActual.plusDays(7).format(formatter)); // 7 días después
    }
    prestamoService.guardarPrestamo(prestamo);
    return "redirect:http://localhost:8080/prestamos";
  }

  @GetMapping("/edit/{id}")
  public String editarPrestamoForm(@PathVariable String id, Model model) {
    Optional<Prestamo> prestamoOptional = prestamoService.obtenerPrestamoPorId(id);
    if (prestamoOptional.isPresent()) {
      Prestamo prestamo = prestamoOptional.get();
      model.addAttribute("prestamo", prestamo);
      model.addAttribute("usuarios", obtenerUsuarios());
      model.addAttribute("libros", obtenerLibros());
      return "nuevo_prestamo";
    } else {
      return "redirect:/prestamos";
    }
  }

  @GetMapping("/delete/{id}")
  public String eliminarPrestamo(@PathVariable String id) {
    prestamoService.eliminarPrestamo(id);
    return "redirect:http://localhost:8080/prestamos";
  }

  private List<Usuario> obtenerUsuarios() {
    ResponseEntity<List<Usuario>> response = restTemplate.exchange(
        "http://usuario-service:8084/api/usuarios",
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<Usuario>>() {
        });
    return response.getBody();
  }

  private List<Libro> obtenerLibros() {
    ResponseEntity<List<Libro>> response = restTemplate.exchange(
        "http://libros-service:8081/api/libros",
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<Libro>>() {
        });
    return response.getBody();
  }
}
