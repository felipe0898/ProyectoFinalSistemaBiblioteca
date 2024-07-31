package com.example.prestamos.repository;

import com.example.prestamos.model.Prestamo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PrestamoRepository extends MongoRepository<Prestamo, String> {
}
