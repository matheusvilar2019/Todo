package com.example.todo.service;

import com.example.todo.domain.model.Tarefa;
import com.example.todo.dto.TarefaRequestDTO;

public interface TarefaService {
    Tarefa findById(Long id);
    Tarefa create(TarefaRequestDTO tarefaRequestDTO);
    Tarefa update(TarefaRequestDTO tarefaRequestDTO);

}
