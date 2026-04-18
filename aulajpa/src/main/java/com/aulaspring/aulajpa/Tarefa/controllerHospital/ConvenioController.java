package com.aulaspring.aulajpa.Tarefa.controllerHospital;

import com.aulaspring.aulajpa.Tarefa.modelHospital.Convenio;
import com.aulaspring.aulajpa.Tarefa.serviceHospital.ConvenioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/convenio")
public class ConvenioController {
    private ConvenioService convenioService;

    public ConvenioController(ConvenioService convenioService) {
        this.convenioService = convenioService;
    }

    @PostMapping
    public Convenio salvarConvenio(@RequestBody Convenio convenio) {
        return this.convenioService.salvar(convenio);
    }

    @GetMapping
    public List<Convenio> todosConvenio() {
        return this.convenioService.todos();
    }

    @GetMapping("{id}")
    public Convenio porId(@PathVariable Long id) {
        return this.convenioService.porId(id);
    }

    @PostMapping("{id}")
    public Convenio atualizaConvenio(@PathVariable Long id, @RequestBody Convenio convenio) {
        return this.convenioService.atualizar(id, convenio);
    }

    @DeleteMapping("{id}")
    public boolean excluiConvenio(@PathVariable Long id) {
        return this.convenioService.excluir(id);
    }
}
