package com.aulaspring.aulajpa.Aula.repositoryEscola;

import com.aulaspring.aulajpa.Aula.modelEscola.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, String> {
}
