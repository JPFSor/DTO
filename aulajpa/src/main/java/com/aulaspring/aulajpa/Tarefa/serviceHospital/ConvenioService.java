package com.aulaspring.aulajpa.Tarefa.serviceHospital;

import com.aulaspring.aulajpa.Tarefa.modelHospital.Consulta;
import com.aulaspring.aulajpa.Tarefa.modelHospital.Convenio;
import com.aulaspring.aulajpa.Tarefa.repositoryHospital.ConsultaRepository;
import com.aulaspring.aulajpa.Tarefa.repositoryHospital.ConvenioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConvenioService {
    private ConvenioRepository convenioRepository;
    private ConsultaRepository consultaRepository;

    public ConvenioService(ConvenioRepository convenioRepository) {
        this.convenioRepository = convenioRepository;
        this.consultaRepository = consultaRepository;
    }

    public Convenio salvar(Convenio convenio) {
        List<Consulta> consultaSalvar = this.consultaRepository.saveAll(convenio.getConsultas());
        convenio.setConsultas(consultaSalvar);
        return this.convenioRepository.save(convenio);
    }

    public List<Convenio> todos() { return convenioRepository.findAll();}
    public Convenio porId(Long id) {
        return this.convenioRepository.findById(id).orElse(null);
    }

    public Convenio atualizar(Long id, Convenio convenio) {
        Convenio convenioConsulta = this.convenioRepository.findById(id).orElse(null);
        if(convenioConsulta != null) {
            convenioConsulta.setNome(convenio.getNome());
            convenioConsulta.setCnpj(convenio.getCnpj());
            convenioConsulta.setConsultas(convenio.getConsultas());
            return this.convenioRepository.save(convenio);
        }
        return null;
    }

    public boolean excluir(Long id) {
        this.convenioRepository.deleteById(id);
        return true;
    }
}
