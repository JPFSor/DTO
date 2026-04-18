package com.aulaspring.aulajpa.Tarefa.controllerHospital;

import com.aulaspring.aulajpa.Tarefa.modelHospital.Prontuario;
import com.aulaspring.aulajpa.Tarefa.serviceHospital.ProntuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prontuario")
public class ProntuarioController {
    private ProntuarioService prontuarioService;

    public ProntuarioController(ProntuarioService prontuarioService) {
        this.prontuarioService = prontuarioService;
    }

    @PostMapping
    public Prontuario salvarProntuario(@RequestBody Prontuario prontuario) {
        return this.prontuarioService.salvar(prontuario);
    }

    @GetMapping
    public List<Prontuario> todosProntuario() {
        return this.prontuarioService.todos();
    }

    @GetMapping("{id}")
    public Prontuario porId(@PathVariable Long id) {
        return this.prontuarioService.porId(id);
    }

    @PostMapping("{id}")
    public Prontuario atualizaProntuario(@PathVariable Long id, @RequestBody Prontuario prontuario) {
        return this.prontuarioService.atualizar(id, prontuario);
    }

    @DeleteMapping("{id}")
    public boolean excluiProntuario(@PathVariable Long id) {
        return this.prontuarioService.excluir(id);
    }
}
