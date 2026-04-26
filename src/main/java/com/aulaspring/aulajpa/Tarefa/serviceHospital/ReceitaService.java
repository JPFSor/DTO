package com.aulaspring.aulajpa.Tarefa.serviceHospital;

import com.aulaspring.aulajpa.Tarefa.dtoHospital.PacienteResponseDTO;
import com.aulaspring.aulajpa.Tarefa.dtoHospital.ReceitaRequestDTO;
import com.aulaspring.aulajpa.Tarefa.dtoHospital.ReceitaResponseDTO;
import com.aulaspring.aulajpa.Tarefa.modelHospital.Consulta;
import com.aulaspring.aulajpa.Tarefa.modelHospital.Receita;
import com.aulaspring.aulajpa.Tarefa.repositoryHospital.ConsultaRepository;
import com.aulaspring.aulajpa.Tarefa.repositoryHospital.ReceitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceitaService {
    private final ReceitaRepository repository;

    public ReceitaService(ReceitaRepository repository) {
        this.repository = repository;
    }

    private Receita toEntity(ReceitaRequestDTO dto) {
        Receita r = new Receita();
        r.setMedicamento(dto.getMedicamento());
        r.setDosagem(dto.getDosagem());
        r.setDuracaoDias(dto.getDuracaoDias());
        return r;
    }

    private ReceitaResponseDTO toDTO(Receita receita) {
        return ReceitaResponseDTO.builder()
                .id(receita.getId())
                .medicamento(receita.getMedicamento())
                .dosagem(receita.getDosagem())
                .duracaoDias(receita.getDuracaoDias())
                .build();
    }
    public List<ReceitaResponseDTO> todos() {
        return repository.findAll().stream().map(this::toDTO).toList();
    }

    public ReceitaResponseDTO porId(Long id) {
        return repository.findById(id).map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Receita não encontrada"));
    }

    public ReceitaResponseDTO salvar(ReceitaRequestDTO dto) {
        return toDTO(repository.save(toEntity(dto)));
    }

    public ReceitaResponseDTO atualizar(Long id, ReceitaRequestDTO dto) {
        Receita receita = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Receita não encontrada"));

        receita.setMedicamento(dto.getMedicamento());
        receita.setDosagem(dto.getDosagem());
        receita.setDuracaoDias(dto.getDuracaoDias());

        return toDTO(repository.save(receita));
    }
    public String excluir(Long id) {
        repository.deleteById(id);
        return "Receita excluída com sucesso";
    }
}