package com.aulaspring.aulajpa.Tarefa.serviceHospital;

import com.aulaspring.aulajpa.Aula.dto.UsuarioRequestDTO;
import com.aulaspring.aulajpa.Aula.dto.UsuarioResponseDTO;
import com.aulaspring.aulajpa.Aula.model.Usuario;
import com.aulaspring.aulajpa.Tarefa.dtoHospital.PacienteRequestDTO;
import com.aulaspring.aulajpa.Tarefa.dtoHospital.PacienteResponseDTO;
import com.aulaspring.aulajpa.Tarefa.modelHospital.Paciente;
import com.aulaspring.aulajpa.Tarefa.repositoryHospital.PacienteRepository;
import com.aulaspring.aulajpa.Tarefa.repositoryHospital.ProntuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    private final PacienteRepository repository;
    private final ProntuarioRepository prontuarioRepository;

    public PacienteService(PacienteRepository repository, ProntuarioRepository prontuarioRepository) {
        this.repository = repository;
        this.prontuarioRepository = prontuarioRepository;
    }

    private Paciente toEntity(PacienteRequestDTO dto) {
        Paciente paciente = new Paciente();
        paciente.setNome(dto.getNome());
        paciente.setCpf(dto.getCpf());
        paciente.setTelefone(dto.getTelefone());
        if (dto.getProntuarioId() != null) {
            paciente.setProntuario(prontuarioRepository.findById(dto.getProntuarioId()).orElse(null));
        }
        return paciente;
    }

    private PacienteResponseDTO toDTO(Paciente paciente) {
        return PacienteResponseDTO.builder()
                .id(paciente.getId())
                .nome(paciente.getNome())
                .cpf(paciente.getCpf())
                .telefone(paciente.getTelefone())
                .build();
    }

    public PacienteResponseDTO salvar(PacienteRequestDTO dto) {
        Paciente salvo = repository.save(toEntity(dto));
        return toDTO(salvo);
    }

    public List<PacienteResponseDTO> todos() {
        return repository.findAll().stream().map(this::toDTO).toList();
    }

    public PacienteResponseDTO porId(Long id) {
        return repository.findById(id).map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
    }

    public PacienteResponseDTO atualizar(Long id, PacienteRequestDTO dto) {
        Paciente paciente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        paciente.setNome(dto.getNome());
        paciente.setCpf(dto.getCpf());
        paciente.setTelefone(dto.getTelefone());

        if (dto.getProntuarioId() != null) {
            paciente.setProntuario(prontuarioRepository.findById(dto.getProntuarioId())
                    .orElseThrow(() -> new RuntimeException("Prontuário não encontrado")));
        }

        return toDTO(repository.save(paciente));
    }

    public String excluir(Long id) {
        repository.deleteById(id);
        return "Paciente excluído com sucesso";
    }
}