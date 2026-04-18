package com.aulaspring.aulajpa.Tarefa.controllerHospital;

import com.aulaspring.aulajpa.Tarefa.modelHospital.Consulta;
import com.aulaspring.aulajpa.Tarefa.serviceHospital.ConsultaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
    private ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @PostMapping
    public Consulta salvarConsulta(@RequestBody Consulta consulta) {
        return this.consultaService.salvar(consulta);
    }

    @GetMapping
    public List<Consulta> todosConsulta() {
        return this.consultaService.todos();
    }

    @GetMapping("{id}")
    public Consulta porId(@PathVariable Long id) {
        return this.consultaService.porId(id);
    }

    @PostMapping("{id}")
    public Consulta atualizaConsulta(@PathVariable Long id, @RequestBody Consulta consulta) {
        return this.consultaService.atualizar(id, consulta);
    }

    @DeleteMapping("{id}")
    public boolean excluiConsulta(@PathVariable Long id) {
        return this.consultaService.excluir(id);
    }
}
