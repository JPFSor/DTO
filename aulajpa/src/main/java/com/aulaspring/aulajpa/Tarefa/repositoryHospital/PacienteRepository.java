package com.aulaspring.aulajpa.Tarefa.repositoryHospital;

import com.aulaspring.aulajpa.Tarefa.modelHospital.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
