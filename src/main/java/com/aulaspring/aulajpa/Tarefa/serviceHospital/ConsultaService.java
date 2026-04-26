package com.aulaspring.aulajpa.Tarefa.serviceHospital;

import com.aulaspring.aulajpa.Tarefa.dtoHospital.ConsultaRequestDTO;
import com.aulaspring.aulajpa.Tarefa.dtoHospital.ConsultaResponseDTO;
import com.aulaspring.aulajpa.Tarefa.dtoHospital.PacienteResponseDTO;
import com.aulaspring.aulajpa.Tarefa.modelHospital.*;
import com.aulaspring.aulajpa.Tarefa.repositoryHospital.*;
import com.aulaspring.aulajpa.Tarefa.modelHospital.*;
import com.aulaspring.aulajpa.Tarefa.repositoryHospital.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {
    private final ConsultaRepository repository;
    private final PacienteRepository pacienteRepo;
    private final MedicoRepository medicoRepo;
    private final ReceitaRepository receitaRepo;
    private final ConvenioRepository convenioRepo;

    public ConsultaService(ConsultaRepository repository, PacienteRepository pacienteRepo,
                           MedicoRepository medicoRepo, ReceitaRepository receitaRepo,
                           ConvenioRepository convenioRepo) {
        this.repository = repository;
        this.pacienteRepo = pacienteRepo;
        this.medicoRepo = medicoRepo;
        this.receitaRepo = receitaRepo;
        this.convenioRepo = convenioRepo;
    }

    private Consulta toEntity(ConsultaRequestDTO dto) {
        Consulta consulta = new Consulta();
        consulta.setDataHora(dto.getDataHora());
        consulta.setMotivo(dto.getMotivo());
        consulta.setValor(dto.getValor());

        consulta.setPaciente(pacienteRepo.findById(dto.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado")));
        consulta.setMedico(medicoRepo.findById(dto.getMedicoId())
                .orElseThrow(() -> new RuntimeException("Médico não encontrado")));

        if (dto.getReceitaId() != null) {
            consulta.setReceita(receitaRepo.findById(dto.getReceitaId()).orElse(null));
        }
        if (dto.getConvenioId() != null) {
            consulta.setConvenio(convenioRepo.findById(dto.getConvenioId()).orElse(null));
        }

        return consulta;
    }

    private ConsultaResponseDTO toDTO(Consulta consulta) {
        return ConsultaResponseDTO.builder()
                .id(consulta.getId())
                .dataHora(consulta.getDataHora())
                .motivo(consulta.getMotivo())
                .valor(consulta.getValor())
                .nomePaciente(consulta.getPaciente().getNome())
                .nomeMedico(consulta.getMedico().getNome())
                .build();
    }

    public ConsultaResponseDTO porId(Long id) {
        return repository.findById(id).map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
    }

    public ConsultaResponseDTO salvar(ConsultaRequestDTO dto) {
        return toDTO(repository.save(toEntity(dto)));
    }

    public List<ConsultaResponseDTO> todos() {
        return repository.findAll().stream().map(this::toDTO).toList();
    }
    public ConsultaResponseDTO atualizar(Long id, ConsultaRequestDTO dto) {
        Consulta consulta = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));

        consulta.setDataHora(dto.getDataHora());
        consulta.setMotivo(dto.getMotivo());
        consulta.setValor(dto.getValor());

        consulta.setPaciente(pacienteRepo.findById(dto.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado")));
        consulta.setMedico(medicoRepo.findById(dto.getMedicoId())
                .orElseThrow(() -> new RuntimeException("Médico não encontrado")));

        if (dto.getReceitaId() != null) {
            consulta.setReceita(receitaRepo.findById(dto.getReceitaId()).orElse(null));
        }

        if (dto.getConvenioId() != null) {
            consulta.setConvenio(convenioRepo.findById(dto.getConvenioId()).orElse(null));
        }

        return toDTO(repository.save(consulta));
    }
    public String excluir(Long id) {
        repository.deleteById(id);
        return "Consulta excluída com sucesso";
    }
}