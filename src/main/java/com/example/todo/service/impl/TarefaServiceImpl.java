package com.example.todo.service.impl;

import com.example.todo.domain.model.Tarefa;
import com.example.todo.domain.model.Usuario;
import com.example.todo.domain.repository.TarefaRepository;
import com.example.todo.domain.repository.UsuarioRepository;
import com.example.todo.dto.TarefaRequestDTO;
import com.example.todo.service.TarefaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TarefaServiceImpl implements TarefaService {

    private TarefaRepository tarefaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    public TarefaServiceImpl(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    @Override
    public Tarefa findById(Long id) {
        return tarefaRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Tarefa create(TarefaRequestDTO tarefaDTO) {
        Tarefa tarefa = new Tarefa();
        tarefa.setNome(tarefaDTO.getNome());
        tarefa.setStatus(tarefaDTO.getStatus());
        tarefa.setPrazo(tarefaDTO.getPrazo());

        if (tarefaDTO.getResponsavelId() != null) {
            Usuario responsavel = usuarioRepository.findById(tarefaDTO.getResponsavelId())
                    .orElseThrow(() -> new IllegalArgumentException("User ID does not exists"));
            tarefa.setResponsavel(responsavel);
        }

        return tarefaRepository.save(tarefa);
    }

    @Override
    public Tarefa update(TarefaRequestDTO tarefaDTO) {
        Optional<Tarefa> optionalTarefa = tarefaRepository.findById(tarefaDTO.getId());

        if (optionalTarefa.isPresent()) {
            Tarefa tarefa = optionalTarefa.get();

            tarefa.setNome(tarefaDTO.getNome());
            tarefa.setStatus(tarefaDTO.getStatus());
            tarefa.setPrazo(tarefaDTO.getPrazo());

            if (tarefaDTO.getResponsavelId() != null) {
                Usuario responsavel = usuarioRepository.findById(tarefaDTO.getResponsavelId())
                        .orElseThrow(() -> new IllegalArgumentException("User ID does not exists"));
                tarefa.setResponsavel(responsavel);
            }

            return tarefa;
        } else {
            throw new EntityNotFoundException();
        }
    }
}
