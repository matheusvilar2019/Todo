package com.example.todo.controller;

import com.example.todo.domain.model.Tarefa;
import com.example.todo.dto.TarefaRequestDTO;
import com.example.todo.service.TarefaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Tarefa> findById(@PathVariable Long id) {
        Tarefa tarefa = tarefaService.findById(id);
        return ResponseEntity.ok(tarefa);
    }

    @PostMapping
    public ResponseEntity<Tarefa> create(@RequestBody TarefaRequestDTO tarefaDTO) {
        Tarefa tarefaCreated = tarefaService.create(tarefaDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(tarefaCreated)
                .toUri();
        return ResponseEntity.created(location).body(tarefaCreated);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Tarefa> update(@RequestBody @Valid TarefaRequestDTO tarefaDTO) {
        Tarefa tarefaUpdated = tarefaService.update(tarefaDTO);
        return ResponseEntity.ok(tarefaUpdated);
    }

}
