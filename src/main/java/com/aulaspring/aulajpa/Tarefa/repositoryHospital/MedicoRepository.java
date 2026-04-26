package com.aulaspring.aulajpa.Tarefa.repositoryHospital;

import com.aulaspring.aulajpa.Tarefa.modelHospital.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
