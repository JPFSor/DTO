package com.aulaspring.aulajpa.Tarefa.serviceHospital;

import com.aulaspring.aulajpa.Tarefa.dtoHospital.MedicoRequestDTO;
import com.aulaspring.aulajpa.Tarefa.dtoHospital.MedicoResponseDTO;
import com.aulaspring.aulajpa.Tarefa.modelHospital.Consulta;
import com.aulaspring.aulajpa.Tarefa.modelHospital.Medico;
import com.aulaspring.aulajpa.Tarefa.repositoryHospital.ConsultaRepository;
import com.aulaspring.aulajpa.Tarefa.repositoryHospital.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {
    private final MedicoRepository repository;

    public MedicoService(MedicoRepository repository) {
        this.repository = repository;
    }

    private Medico toEntity(MedicoRequestDTO dto) {
        Medico medico = new Medico();
        medico.setNome(dto.getNome());
        medico.setCrm(dto.getCrm());
        medico.setEspecialidade(dto.getEspecialidade());
        return medico;
    }

    private MedicoResponseDTO toDTO(Medico medico) {
        return MedicoResponseDTO.builder()
                .id(medico.getId())
                .nome(medico.getNome())
                .crm(medico.getCrm())
                .especialidade(medico.getEspecialidade())
                .build();
    }

    public MedicoResponseDTO salvar(MedicoRequestDTO dto) {
        return toDTO(repository.save(toEntity(dto)));
    }

    public List<MedicoResponseDTO> todos() {
        return repository.findAll().stream().map(this::toDTO).toList();
    }

    public MedicoResponseDTO porId(Long id) {
        return repository.findById(id).map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Médico não encontrado"));
    }

    public MedicoResponseDTO atualizar(Long id, MedicoRequestDTO dto) {
        Medico medico = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Médico não encontrado"));

        medico.setNome(dto.getNome());
        medico.setCrm(dto.getCrm());
        medico.setEspecialidade(dto.getEspecialidade());

        return toDTO(repository.save(medico));
    }

    public String excluir(Long id) {
        repository.deleteById(id);
        return "Médico excluído com sucesso";
    }
}