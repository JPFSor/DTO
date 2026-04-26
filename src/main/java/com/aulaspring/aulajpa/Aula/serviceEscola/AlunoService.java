package com.aulaspring.aulajpa.Aula.serviceEscola;

import com.aulaspring.aulajpa.Aula.modelEscola.Aluno;
import com.aulaspring.aulajpa.Aula.modelEscola.Endereco;
import com.aulaspring.aulajpa.Aula.repositoryEscola.AlunoRepository;
import com.aulaspring.aulajpa.Aula.repositoryEscola.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    private AlunoRepository alunoRepository;
    private EnderecoRepository enderecoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
        this.enderecoRepository = enderecoRepository;
    }

    public Aluno salvar(Aluno aluno) {
        Endereco enderecoSalvar = this.enderecoRepository.save(aluno.getEndereco());
        aluno.setEndereco(enderecoSalvar);
        return this.alunoRepository.save(aluno);
    }
    public List<Aluno> todos() {
        return this.alunoRepository.findAll();
    }
    public Aluno porRA(String ra) {
        return this.alunoRepository.findById(ra).orElse(null);
    }
    public Aluno atualizar(String ra, Aluno aluno) {
        Aluno alunoConsulta = this.alunoRepository.findById(ra).orElse(null);
        if (alunoConsulta != null) {
            alunoConsulta.setNome(aluno.getNome());
            alunoConsulta.setEndereco(aluno.getEndereco());
            alunoConsulta.setEmail(aluno.getEmail());
            return this.alunoRepository.save(alunoConsulta);
        }
        return null;
    }
    public boolean excluir(String ra) {
        this.alunoRepository.deleteById(ra);
        return true;
    }
}
