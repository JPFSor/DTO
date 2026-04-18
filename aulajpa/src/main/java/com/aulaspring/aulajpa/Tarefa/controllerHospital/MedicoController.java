package com.aulaspring.aulajpa.Tarefa.controllerHospital;

import com.aulaspring.aulajpa.Tarefa.modelHospital.Medico;
import com.aulaspring.aulajpa.Tarefa.serviceHospital.MedicoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {
    private MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @PostMapping
        public Medico salvarMedico(@RequestBody Medico medico) {
        return this.medicoService.salvar(medico);
    }

    @GetMapping
    public List<Medico> todosMedico() {
        return this.medicoService.todos();
    }

    @GetMapping("{id}")
    public Medico porId(@PathVariable Long id) {
        return this.medicoService.porId(id);
    }

    @PostMapping("{id}")
    public Medico atualizaMedico(@PathVariable Long id, @RequestBody Medico medico) {
        return this.medicoService.atualizar(id, medico);
    }

    @DeleteMapping("{id}")
    public boolean excluiMedico(@PathVariable Long id) {
        return this.medicoService.excluir(id);
    }
}
