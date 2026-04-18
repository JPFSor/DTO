package com.aulaspring.aulajpa.Tarefa.serviceHospital;

import com.aulaspring.aulajpa.Tarefa.modelHospital.*;
import com.aulaspring.aulajpa.Tarefa.repositoryHospital.*;
import com.aulaspring.aulajpa.Tarefa.modelHospital.*;
import com.aulaspring.aulajpa.Tarefa.repositoryHospital.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {
    private ConsultaRepository consultaRepository;
    private PacienteRepository pacienteRepository;
    private MedicoRepository medicoRepository;
    private ConvenioRepository convenioRepository;
    private ReceitaRepository receitaRepository;

    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
        this.pacienteRepository = pacienteRepository;
        this.medicoRepository = medicoRepository;
        this.convenioRepository = convenioRepository;
        this.receitaRepository = receitaRepository;
    }

    public Consulta salvar(Consulta consulta) {
        Paciente pacienteSalvar = this.pacienteRepository.save(consulta.getPaciente());
        consulta.setPaciente(pacienteSalvar);
        Medico medicoSalvar = this.medicoRepository.save(consulta.getMedico());
        consulta.setMedico(medicoSalvar);
        Convenio convenioSalvar = this.convenioRepository.save(consulta.getConvenio());
        consulta.setConvenio(convenioSalvar);
        Receita receitaSalvar = this.receitaRepository.save(consulta.getReceita());
        consulta.setReceita(receitaSalvar);
        return this.consultaRepository.save(consulta);
    }

    public List<Consulta> todos() { return this.consultaRepository.findAll();}
    public Consulta porId(Long id) { return consultaRepository.findById(id).orElse(null);}

    public Consulta atualizar(Long id, Consulta consulta) {
        Consulta consultaConsulta = this.consultaRepository.findById(id).orElse(null);
        if(consultaConsulta != null) {
            consultaConsulta.setDataHora(consulta.getDataHora());
            consultaConsulta.setMotivo(consulta.getMotivo());
            consultaConsulta.setValor(consulta.getValor());
            consultaConsulta.setPaciente(consulta.getPaciente());
            consultaConsulta.setMedico(consulta.getMedico());
            consultaConsulta.setConvenio(consulta.getConvenio());
            consultaConsulta.setReceita(consulta.getReceita());
            return this.consultaRepository.save(consultaConsulta);
        }
        return null;
    }

    public boolean excluir(Long id) {
        this.consultaRepository.deleteById(id);
        return true;
    }
}
