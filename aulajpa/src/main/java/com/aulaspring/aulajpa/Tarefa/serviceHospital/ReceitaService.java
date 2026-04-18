package com.aulaspring.aulajpa.Tarefa.serviceHospital;

import com.aulaspring.aulajpa.Tarefa.modelHospital.Consulta;
import com.aulaspring.aulajpa.Tarefa.modelHospital.Receita;
import com.aulaspring.aulajpa.Tarefa.repositoryHospital.ConsultaRepository;
import com.aulaspring.aulajpa.Tarefa.repositoryHospital.ReceitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceitaService {
    private ReceitaRepository receitaRepository;
    private ConsultaRepository consultaRepository;


    public ReceitaService(ReceitaRepository receitaRepository) {
        this.receitaRepository = receitaRepository;
        this.consultaRepository = consultaRepository;
    }

    public Receita salvar(Receita receita) {
        List<Consulta> consultaSalvar = this.consultaRepository.saveAll(receita.getConsultas());
        receita.setConsultas(consultaSalvar);
        return this.receitaRepository.save(receita);
    }

    public List<Receita> todos() {
        return this.receitaRepository.findAll();
    }
    public Receita porId(Long id) {
        return this.receitaRepository.findById(id).orElse(null);
    }

    public Receita atualizar(Long id, Receita receita) {
        Receita receitaConsulta = this.receitaRepository.findById(id).orElse(null);
        if(receitaConsulta != null) {
            receitaConsulta.setMedicamento(receita.getMedicamento());
            receitaConsulta.setDosagem(receita.getDosagem());
            receitaConsulta.setDuracaoDias(receita.getDuracaoDias());
            receitaConsulta.setConsultas(receita.getConsultas());
            return this.receitaRepository.save(receitaConsulta);
        }
        return null;
    }

    public boolean excluir(Long id) {
        this.receitaRepository.deleteById(id);
        return true;
    }
}
