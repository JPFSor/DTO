package com.aulaspring.aulajpa.Tarefa.dtoHospital;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProntuarioResponseDTO {
    private Long id;
    private String tipoSanguineo;
    private String alergia;
    private String observacoes;
}
