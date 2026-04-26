package com.aulaspring.aulajpa.Tarefa.controllerHospital;

import com.aulaspring.aulajpa.Aula.dto.UsuarioRequestDTO;
import com.aulaspring.aulajpa.Aula.dto.UsuarioResponseDTO;
import com.aulaspring.aulajpa.Tarefa.dtoHospital.ConsultaResponseDTO;
import com.aulaspring.aulajpa.Tarefa.dtoHospital.ConvenioRequestDTO;
import com.aulaspring.aulajpa.Tarefa.dtoHospital.ConvenioResponseDTO;
import com.aulaspring.aulajpa.Tarefa.dtoHospital.PacienteResponseDTO;
import com.aulaspring.aulajpa.Tarefa.modelHospital.Convenio;
import com.aulaspring.aulajpa.Tarefa.serviceHospital.ConvenioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/convenio")
public class ConvenioController {
    private final ConvenioService service;

    public ConvenioController(ConvenioService service) {
        this.service = service;
    }

    @PostMapping
    public ConvenioResponseDTO salvar(@RequestBody @Valid ConvenioRequestDTO dto) {
        return this.service.salvar(dto);
    }
    @GetMapping("/{id}")
    public ConvenioResponseDTO porId(@PathVariable Long id) {
        return this.service.porId(id);
    }
    @GetMapping
    public List<ConvenioResponseDTO> todos() {
        return this.service.todos();
    }
    @PutMapping("{id}")
    public ConvenioResponseDTO atualizar(@PathVariable Long id, @RequestBody @Valid ConvenioRequestDTO convenio) {
        return this.service.atualizar(id, convenio);
    }

    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Long id) {
        return this.service.excluir(id);
    }
}
