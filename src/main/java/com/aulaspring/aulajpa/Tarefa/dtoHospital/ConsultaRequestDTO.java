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
public class ConsultaRequestDTO {
    private Date dataHora;
    private String motivo;
    private double valor;
    private Long pacienteId;
    private Long receitaId;
    private Long medicoId;
    private Long convenioId;
}


