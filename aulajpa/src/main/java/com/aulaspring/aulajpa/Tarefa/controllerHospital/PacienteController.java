package com.aulaspring.aulajpa.Tarefa.controllerHospital;

import com.aulaspring.aulajpa.Tarefa.modelHospital.Paciente;
import com.aulaspring.aulajpa.Tarefa.serviceHospital.PacienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    private PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public Paciente salvarPaciente(@RequestBody Paciente paciente) {
        return this.pacienteService.salvar(paciente);
    }

    @GetMapping
    public List<Paciente> todosPaciente() {
        return this.pacienteService.todos();
    }

    @GetMapping("{id}")
    public Paciente porId(@PathVariable Long id) {
        return this.pacienteService.porId(id);
    }

    @PostMapping("{id}")
    public Paciente atualizaPaciente(@PathVariable Long id, @RequestBody Paciente paciente) {
        return this.pacienteService.atualizar(id, paciente);
    }

    @DeleteMapping("{id}")
    public boolean excluiPaciente(@PathVariable Long id) {
        return this.pacienteService.excluir(id);
    }
}
