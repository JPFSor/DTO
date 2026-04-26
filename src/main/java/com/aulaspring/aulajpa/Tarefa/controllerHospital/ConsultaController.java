package com.aulaspring.aulajpa.Tarefa.controllerHospital;

import com.aulaspring.aulajpa.Aula.dto.UsuarioRequestDTO;
import com.aulaspring.aulajpa.Aula.dto.UsuarioResponseDTO;
import com.aulaspring.aulajpa.Tarefa.dtoHospital.ConsultaRequestDTO;
import com.aulaspring.aulajpa.Tarefa.dtoHospital.ConsultaResponseDTO;
import com.aulaspring.aulajpa.Tarefa.dtoHospital.ConvenioResponseDTO;
import com.aulaspring.aulajpa.Tarefa.dtoHospital.PacienteResponseDTO;
import com.aulaspring.aulajpa.Tarefa.modelHospital.Consulta;
import com.aulaspring.aulajpa.Tarefa.serviceHospital.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
    private final ConsultaService service;

    public ConsultaController(ConsultaService service) {
        this.service = service;
    }

    @PostMapping
    public ConsultaResponseDTO salvar(@RequestBody @Valid ConsultaRequestDTO dto) {
        return this.service.salvar(dto);
    }

    @GetMapping("/{id}")
    public ConsultaResponseDTO porId(@PathVariable Long id) {
        return this.service.porId(id);
    }

    @GetMapping
    public List<ConsultaResponseDTO> todos() {
        return this.service.todos();
    }
    @PutMapping("{id}")
    public ConsultaResponseDTO atualizar(@PathVariable Long id, @RequestBody @Valid ConsultaRequestDTO consulta) {
        return this.service.atualizar(id, consulta);
    }

    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Long id) {
        return this.service.excluir(id);
    }
}
