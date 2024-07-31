package com.example.prestamos.service;

import com.example.prestamos.model.Libro;
import com.example.prestamos.model.Prestamo;
import com.example.prestamos.model.Usuario;
import com.example.prestamos.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoService {

  @Autowired
  private PrestamoRepository prestamoRepository;

  @Autowired
  private RestTemplate restTemplate;

  private final String USUARIO_SERVICE_URL = "http://usuario-service:8084";
  private final String LIBRO_SERVICE_URL = "http://libros-service:8081";

  public Prestamo guardarPrestamo(Prestamo prestamo) {
    return prestamoRepository.save(prestamo);
  }

  public List<Prestamo> obtenerTodosLosPrestamos() {
    return prestamoRepository.findAll();
  }

  public Optional<Prestamo> obtenerPrestamoPorId(String id) {
    return prestamoRepository.findById(id);
  }

  public void eliminarPrestamo(String id) {
    prestamoRepository.deleteById(id);
  }

  public Usuario obtenerUsuarioPorId(String usuarioId) {
    return restTemplate.getForObject(USUARIO_SERVICE_URL + "/api/usuarios/" + usuarioId, Usuario.class);
  }

  public Libro obtenerLibroPorId(String libroId) {
    return restTemplate.getForObject(LIBRO_SERVICE_URL + "/api/libros/" + libroId, Libro.class);
  }
}
