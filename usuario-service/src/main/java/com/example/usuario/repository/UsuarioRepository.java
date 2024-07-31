package com.example.usuario.repository;

import com.example.usuario.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
  Usuario findByEmail(String email);

  Usuario findByUsername(String username);

}
