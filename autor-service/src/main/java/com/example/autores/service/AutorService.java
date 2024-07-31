package com.example.autores.service;

import com.example.autores.model.Autor;
import com.example.autores.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
  @Autowired
  private AutorRepository autorRepository;

  public Autor guardarAutor(Autor autor) {
    return autorRepository.save(autor);
  }

  public List<Autor> obtenerTodosLosAutores() {
    return autorRepository.findAll();
  }

  public Optional<Autor> obtenerAutorPorId(String id) {
    return autorRepository.findById(id);
  }

  public Autor actualizarAutor(String id, Autor autorActualizado) {
    Optional<Autor> autor = autorRepository.findById(id);
    if (autor.isPresent()) {
      Autor autorExistente = autor.get();
      autorExistente.setNombre(autorActualizado.getNombre());
      autorExistente.setBiografia(autorActualizado.getBiografia());
      return autorRepository.save(autorExistente);
    } else {
      return null;
    }
  }

  public void eliminarAutor(String id) {
    autorRepository.deleteById(id);
  }
}
