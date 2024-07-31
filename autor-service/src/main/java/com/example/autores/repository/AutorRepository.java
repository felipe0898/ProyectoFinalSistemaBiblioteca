package com.example.autores.repository;

import com.example.autores.model.Autor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AutorRepository extends MongoRepository<Autor, String> {
}
