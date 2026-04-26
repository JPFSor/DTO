package com.aulaspring.aulajpa.Tarefa.controllerHospital;

import com.aulaspring.aulajpa.Aula.dto.UsuarioRequestDTO;
import com.aulaspring.aulajpa.Aula.dto.UsuarioResponseDTO;
import com.aulaspring.aulajpa.Tarefa.dtoHospital.PacienteRequestDTO;
import com.aulaspring.aulajpa.Tarefa.dtoHospital.PacienteResponseDTO;
import com.aulaspring.aulajpa.Tarefa.modelHospital.Paciente;
import com.aulaspring.aulajpa.Tarefa.serviceHospital.PacienteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @PostMapping
    public PacienteResponseDTO salvar(@RequestBody @Valid PacienteRequestDTO dto) {
        return this.service.salvar(dto);
    }

    @GetMapping("/{id}")
    public PacienteResponseDTO porId(@PathVariable Long id) {
        return this.service.porId(id);
    }

    @GetMapping
    public List<PacienteResponseDTO> todos() {
        return this.service.todos();
    }
    @PutMapping("{id}")
    public PacienteResponseDTO atualizar(@PathVariable Long id, @RequestBody @Valid PacienteRequestDTO paciente) {
        return this.service.atualizar(id, paciente);
    }

    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Long id) {
        return this.service.excluir(id);
    }
}
