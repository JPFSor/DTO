package com.aulaspring.aulajpa.Tarefa.serviceHospital;

import com.aulaspring.aulajpa.Tarefa.modelHospital.Prontuario;
import com.aulaspring.aulajpa.Tarefa.repositoryHospital.ProntuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProntuarioService {
    private ProntuarioRepository prontuarioRepository;

    public ProntuarioService(ProntuarioRepository prontuarioRepository) {
        this.prontuarioRepository = prontuarioRepository;
    }

    public Prontuario salvar(Prontuario prontuario) {
        return this.prontuarioRepository.save(prontuario);
    }

    public List<Prontuario> todos() {
        return this.prontuarioRepository.findAll();
    }
    public Prontuario porId(Long id) {
        return this.prontuarioRepository.findById(id).orElse(null);
    }

        public Prontuario atualizar(Long id, Prontuario prontuario) {
        Prontuario prontuarioConsulta = this.prontuarioRepository.findById(id).orElse(null);
        if(prontuarioConsulta != null) {
            prontuarioConsulta.setTipoSanguineo(prontuario.getTipoSanguineo());
            prontuarioConsulta.setAlergia(prontuario.getAlergia());
            prontuarioConsulta.setObservacoes(prontuario.getObservacoes());
            return this.prontuarioRepository.save(prontuarioConsulta);
        }
        return null;
    }

    public boolean excluir(Long id) {
        this.prontuarioRepository.deleteById(id);
        return true;
    }
}
