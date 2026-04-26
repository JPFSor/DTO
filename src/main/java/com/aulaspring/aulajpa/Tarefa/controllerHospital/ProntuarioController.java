package com.aulaspring.aulajpa.Tarefa.controllerHospital;

import com.aulaspring.aulajpa.Aula.dto.UsuarioRequestDTO;
import com.aulaspring.aulajpa.Aula.dto.UsuarioResponseDTO;
import com.aulaspring.aulajpa.Tarefa.dtoHospital.PacienteResponseDTO;
import com.aulaspring.aulajpa.Tarefa.dtoHospital.ProntuarioRequestDTO;
import com.aulaspring.aulajpa.Tarefa.dtoHospital.ProntuarioResponseDTO;
import com.aulaspring.aulajpa.Tarefa.modelHospital.Prontuario;
import com.aulaspring.aulajpa.Tarefa.serviceHospital.ProntuarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prontuario")
public class ProntuarioController {
    private final ProntuarioService service;

    public ProntuarioController(ProntuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ProntuarioResponseDTO salvar(@RequestBody @Valid ProntuarioRequestDTO dto) {
        return this.service.salvar(dto);
    }

    @GetMapping("/{id}")
    public ProntuarioResponseDTO porId(@PathVariable Long id) {
        return this.service.porId(id);
    }
    @GetMapping
    public List<ProntuarioResponseDTO> todos() {
        return this.service.todos();
    }
    @PutMapping("{id}")
    public ProntuarioResponseDTO atualizar(@PathVariable Long id, @RequestBody @Valid ProntuarioRequestDTO prontuario) {
        return this.service.atualizar(id, prontuario);
    }

    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Long id) {
        return this.service.excluir(id);
    }
}
