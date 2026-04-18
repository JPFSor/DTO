package com.aulaspring.aulajpa.Tarefa.controllerHospital;

import com.aulaspring.aulajpa.Tarefa.modelHospital.Receita;
import com.aulaspring.aulajpa.Tarefa.serviceHospital.ReceitaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receita")
public class ReceitaController {
    private ReceitaService receitaService;

    public ReceitaController(ReceitaService receitaService) {
        this.receitaService = receitaService;
    }

    @PostMapping
    public Receita salvarReceita(@RequestBody Receita receita) {
        return this.receitaService.salvar(receita);
    }

    @GetMapping
    public List<Receita> todosReceita() {
        return this.receitaService.todos();
    }

    @GetMapping("{id}")
    public Receita porId(@PathVariable Long id) {
        return this.receitaService.porId(id);
    }

    @PostMapping("{id}")
    public Receita atualizaReceita(@PathVariable Long id, @RequestBody Receita receita) {
        return this.receitaService.atualizar(id, receita);
    }

    @DeleteMapping("{id}")
    public boolean excluiReceita(@PathVariable Long id) {
        return this.receitaService.excluir(id);
    }
}
