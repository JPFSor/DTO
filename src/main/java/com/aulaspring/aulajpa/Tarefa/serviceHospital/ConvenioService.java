package com.aulaspring.aulajpa.Tarefa.serviceHospital;

import com.aulaspring.aulajpa.Tarefa.dtoHospital.ConsultaResponseDTO;
import com.aulaspring.aulajpa.Tarefa.dtoHospital.ConvenioRequestDTO;
import com.aulaspring.aulajpa.Tarefa.dtoHospital.ConvenioResponseDTO;
import com.aulaspring.aulajpa.Tarefa.dtoHospital.PacienteResponseDTO;
import com.aulaspring.aulajpa.Tarefa.modelHospital.Consulta;
import com.aulaspring.aulajpa.Tarefa.modelHospital.Convenio;
import com.aulaspring.aulajpa.Tarefa.repositoryHospital.ConsultaRepository;
import com.aulaspring.aulajpa.Tarefa.repositoryHospital.ConvenioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConvenioService {
    private final ConvenioRepository repository;

    public ConvenioService(ConvenioRepository repository) {
        this.repository = repository;
    }

    private Convenio toEntity(ConvenioRequestDTO dto) {
        Convenio convenio = new Convenio();
        convenio.setNome(dto.getNome());
        convenio.setCnpj(dto.getCnpj());
        return convenio;
    }

    private ConvenioResponseDTO toDTO(Convenio convenio) {
        return ConvenioResponseDTO.builder()
                .id(convenio.getId())
                .nome(convenio.getNome())
                .cnpj(convenio.getCnpj())
                .build();
    }
    public List<ConvenioResponseDTO> todos() {
        return repository.findAll().stream().map(this::toDTO).toList();
    }

    public ConvenioResponseDTO porId(Long id) {
        return repository.findById(id).map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Convênio não encontrado"));
    }

    public ConvenioResponseDTO salvar(ConvenioRequestDTO dto) {
        return toDTO(repository.save(toEntity(dto)));
    }

    public ConvenioResponseDTO atualizar(Long id, ConvenioRequestDTO dto) {
        Convenio convenio = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Convênio não encontrado"));

        convenio.setNome(dto.getNome());
        convenio.setCnpj(dto.getCnpj());

        return toDTO(repository.save(convenio));
    }

    public String excluir(Long id) {
        repository.deleteById(id);
        return "Convênio excluído com sucesso";
    }
}