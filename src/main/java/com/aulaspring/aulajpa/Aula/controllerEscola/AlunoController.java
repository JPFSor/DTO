package com.aulaspring.aulajpa.Aula.controllerEscola;

import com.aulaspring.aulajpa.Aula.modelEscola.Aluno;
import com.aulaspring.aulajpa.Aula.serviceEscola.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    private AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public Aluno salvarAluno(@RequestBody Aluno aluno) {
        return this.alunoService.salvar(aluno);
    }

    @GetMapping
    public List<Aluno> todosAlunos() {
        return this.alunoService.todos();
    }

    @GetMapping("{ra}")
    public Aluno porRA(@PathVariable String ra) {
        return this.alunoService.porRA(ra);
    }

    @PostMapping("{ra}")
    public Aluno atualizaAluno(@PathVariable String ra, @RequestBody Aluno aluno) {
        return this.alunoService.atualizar(ra, aluno);
    }

    @DeleteMapping("{ra}")
    public boolean excluiAluno(@PathVariable String ra) {
        return this.alunoService.excluir(ra);
    }
}
