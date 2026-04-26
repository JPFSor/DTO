package com.aulaspring.aulajpa.Aula.repositoryEscola;

import com.aulaspring.aulajpa.Aula.modelEscola.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
