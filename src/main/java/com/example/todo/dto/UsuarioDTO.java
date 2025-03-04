package com.example.todo.dto;

import com.example.todo.domain.model.Usuario;

public record UsuarioDTO(Long id, String nome, String email) {
    public static UsuarioDTO fromEntity(Usuario usuario) {
        return new UsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getEmail());
    }
}