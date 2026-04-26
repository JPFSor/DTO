package com.aulaspring.aulajpa.Tarefa.dtoHospital;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicoRequestDTO {
    private String nome;
    private String especialidade;
    private String crm;
}


