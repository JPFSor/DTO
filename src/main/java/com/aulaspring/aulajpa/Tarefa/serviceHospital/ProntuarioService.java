package com.aulaspring.aulajpa.Tarefa.serviceHospital;

import com.aulaspring.aulajpa.Tarefa.dtoHospital.PacienteResponseDTO;
import com.aulaspring.aulajpa.Tarefa.dtoHospital.ProntuarioRequestDTO;
import com.aulaspring.aulajpa.Tarefa.dtoHospital.ProntuarioResponseDTO;
import com.aulaspring.aulajpa.Tarefa.modelHospital.Prontuario;
import com.aulaspring.aulajpa.Tarefa.repositoryHospital.ProntuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProntuarioService {
    private final ProntuarioRepository repository;

    public ProntuarioService(ProntuarioRepository repository) {
        this.repository = repository;
    }

    private Prontuario toEntity(ProntuarioRequestDTO dto) {
        Prontuario r = new Prontuario();
        r.setAlergia(dto.getAlergia());
        r.setObservacoes(dto.getObservacoes());
        r.setTipoSanguineo(dto.getTipoSanguineo());
        return r;
    }

    private ProntuarioResponseDTO toDTO(Prontuario prontuario) {
        return ProntuarioResponseDTO.builder()
                .id(prontuario.getId())
                .tipoSanguineo(prontuario.getTipoSanguineo())
                .alergia(prontuario.getAlergia())
                .observacoes(prontuario.getObservacoes())
                .build();
    }
    public List<ProntuarioResponseDTO> todos() {
        return repository.findAll().stream().map(this::toDTO).toList();
    }

    public ProntuarioResponseDTO porId(Long id) {
        return repository.findById(id).map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Prontuario não encontrado"));
    }

    public ProntuarioResponseDTO salvar(ProntuarioRequestDTO dto) {
        return toDTO(repository.save(toEntity(dto)));
    }
    public ProntuarioResponseDTO atualizar(Long id, ProntuarioRequestDTO dto) {
        Prontuario prontuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prontuário não encontrado"));

        prontuario.setTipoSanguineo(dto.getTipoSanguineo());
        prontuario.setAlergia(dto.getAlergia());
        prontuario.setObservacoes(dto.getObservacoes());

        return toDTO(repository.save(prontuario));
    }
    public String excluir(Long id) {
        repository.deleteById(id);
        return "Prontuário excluído com sucesso";
    }
}
