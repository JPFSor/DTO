package com.aulaspring.aulajpa.Tarefa.dtoHospital;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaResponseDTO {
    private Long id;
    private Date dataHora;
    private String motivo;
    private double valor;
    private String nomePaciente;
    private String nomeMedico;
}
