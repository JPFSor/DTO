package com.aulaspring.aulajpa.Tarefa.controllerHospital;

import com.aulaspring.aulajpa.Aula.dto.UsuarioRequestDTO;
import com.aulaspring.aulajpa.Aula.dto.UsuarioResponseDTO;
import com.aulaspring.aulajpa.Tarefa.dtoHospital.PacienteResponseDTO;
import com.aulaspring.aulajpa.Tarefa.dtoHospital.ReceitaRequestDTO;
import com.aulaspring.aulajpa.Tarefa.dtoHospital.ReceitaResponseDTO;
import com.aulaspring.aulajpa.Tarefa.modelHospital.Receita;
import com.aulaspring.aulajpa.Tarefa.serviceHospital.ReceitaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receita")
public class ReceitaController {
    private final ReceitaService service;

    public ReceitaController(ReceitaService service) {
        this.service = service;
    }

    @PostMapping
    public ReceitaResponseDTO salvar(@RequestBody @Valid ReceitaRequestDTO dto) {
        return this.service.salvar(dto);
    }

    @GetMapping("/{id}")
    public ReceitaResponseDTO porId(@PathVariable Long id) {
        return this.service.porId(id);
    }
    @GetMapping
    public List<ReceitaResponseDTO> todos() {
        return this.service.todos();
    }
    @PutMapping("{id}")
    public ReceitaResponseDTO atualizar(@PathVariable Long id, @RequestBody @Valid ReceitaRequestDTO receita) {
        return this.service.atualizar(id, receita);
    }

    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Long id) {
        return this.service.excluir(id);
    }
}