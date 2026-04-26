package com.aulaspring.aulajpa.Tarefa.controllerHospital;

import com.aulaspring.aulajpa.Aula.dto.UsuarioRequestDTO;
import com.aulaspring.aulajpa.Aula.dto.UsuarioResponseDTO;
import com.aulaspring.aulajpa.Tarefa.dtoHospital.MedicoRequestDTO;
import com.aulaspring.aulajpa.Tarefa.dtoHospital.MedicoResponseDTO;
import com.aulaspring.aulajpa.Tarefa.dtoHospital.PacienteResponseDTO;
import com.aulaspring.aulajpa.Tarefa.modelHospital.Medico;
import com.aulaspring.aulajpa.Tarefa.serviceHospital.MedicoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {
    private final MedicoService service;

    public MedicoController(MedicoService service) {
        this.service = service;
    }

    @PostMapping
    public MedicoResponseDTO salvar(@RequestBody @Valid MedicoRequestDTO dto) {
        return this.service.salvar(dto);
    }

    @GetMapping("/{id}")
    public MedicoResponseDTO porId(@PathVariable Long id) {
        return this.service.porId(id);
    }

    @GetMapping
    public List<MedicoResponseDTO> todos() {
        return this.service.todos();
    }
    @PutMapping("{id}")
    public MedicoResponseDTO atualizar(@PathVariable Long id, @RequestBody @Valid MedicoRequestDTO medico) {
        return this.service.atualizar(id, medico);
    }

    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Long id) {
        return this.service.excluir(id);
    }
}
