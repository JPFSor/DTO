package com.aulaspring.aulajpa.Tarefa.serviceHospital;

import com.aulaspring.aulajpa.Tarefa.modelHospital.Consulta;
import com.aulaspring.aulajpa.Tarefa.modelHospital.Paciente;
import com.aulaspring.aulajpa.Tarefa.modelHospital.Prontuario;
import com.aulaspring.aulajpa.Tarefa.repositoryHospital.ConsultaRepository;
import com.aulaspring.aulajpa.Tarefa.repositoryHospital.PacienteRepository;
import com.aulaspring.aulajpa.Tarefa.repositoryHospital.ProntuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    private PacienteRepository pacienteRepository;
    private ConsultaRepository consultaRepository;
    private ProntuarioRepository prontuarioRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
        this.consultaRepository = consultaRepository;
        this.prontuarioRepository = prontuarioRepository;
    }

    public Paciente salvar(Paciente paciente) {
        List<Consulta> consultaSalvar = this.consultaRepository.saveAll(paciente.getConsultas());
        paciente.setConsultas(consultaSalvar);
        Prontuario prontuarioSalvar = this.prontuarioRepository.save(paciente.getProntuario());
        paciente.setProntuario(prontuarioSalvar);
        return this.pacienteRepository.save(paciente);
    }

    public List<Paciente> todos() {
        return this.pacienteRepository.findAll();
    }
    public Paciente porId(Long id) {
        return this.pacienteRepository.findById(id).orElse(null);
    }

    public Paciente atualizar(Long id, Paciente paciente) {
        Paciente pacienteConsulta = this.pacienteRepository.findById(id).orElse(null);
        if(pacienteConsulta != null) {
            pacienteConsulta.setNome(paciente.getNome());
            pacienteConsulta.setCpf(paciente.getCpf());
            pacienteConsulta.setTelefone(paciente.getTelefone());
            pacienteConsulta.setConsultas(paciente.getConsultas());
            pacienteConsulta.setProntuario(paciente.getProntuario());
            return this.pacienteRepository.save(pacienteConsulta);
        }
        return null;
    }

    public boolean excluir(Long id) {
        this.pacienteRepository.deleteById(id);
        return true;
    }
}
