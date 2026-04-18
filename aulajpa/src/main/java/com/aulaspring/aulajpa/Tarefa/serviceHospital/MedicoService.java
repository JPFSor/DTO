package com.aulaspring.aulajpa.Tarefa.serviceHospital;

import com.aulaspring.aulajpa.Tarefa.modelHospital.Consulta;
import com.aulaspring.aulajpa.Tarefa.modelHospital.Medico;
import com.aulaspring.aulajpa.Tarefa.repositoryHospital.ConsultaRepository;
import com.aulaspring.aulajpa.Tarefa.repositoryHospital.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {
    private MedicoRepository medicoRepository;
    private ConsultaRepository consultaRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
        this.consultaRepository = consultaRepository;

    }

    public Medico salvar(Medico medico) {
        List<Consulta> consultaSalvar = this.consultaRepository.saveAll(medico.getConsultas());
        medico.setConsultas(consultaSalvar);
        return this.medicoRepository.save(medico);
    }

    public List<Medico> todos() {
        return this.medicoRepository.findAll();
    }
    public Medico porId(Long id) {
        return this.medicoRepository.findById(id).orElse(null);
    }

    public Medico atualizar(Long id, Medico medico) {
        Medico medicoConsulta = this.medicoRepository.findById(id).orElse(null);
        if(medicoConsulta != null) {
            medicoConsulta.setNome(medico.getNome());
            medicoConsulta.setCrm(medico.getCrm());
            medicoConsulta.setEspecialidade(medico.getEspecialidade());
            medicoConsulta.setConsultas(medico.getConsultas());
            return this.medicoRepository.save(medicoConsulta);
        }
        return null;
    }

    public boolean excluir(Long id) {
        this.medicoRepository.deleteById(id);
        return true;
    }
}
