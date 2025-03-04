package com.example.todo.service;

import com.example.todo.domain.model.Usuario;
import com.example.todo.dto.UsuarioDTO;

public interface UsuarioService {
    Usuario findById(Long id);
    Usuario create(UsuarioDTO usuarioToCreate);
}
