package br.edu.famper.clinicaodontologica.dto;

import br.edu.famper.clinicaodontologica.model.Dentista;
import br.edu.famper.clinicaodontologica.model.Paciente;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ConsultaDto {

    @Schema(description =  "Id da consulta",
            example = "1",
            title = "id")
    private Long id;

    @Schema(description = "Descricao da consulta",
            example = "Dor de dente",
            title = "descricao",
            maxLength = 150)
    private String descricao;

    @Schema(description = "Valor da consulta",
            example = "200.00",
            title = "valor")
    private Double valor;

    @Schema(description = "Data da consulta",
            example = "2024-10-10",
            title = "data")
    private Date data;

    @Schema(description = "Nome do dentista",
            example = "Coloridinho da Silva",
            title = "Nome do dentista",
            maxLength = 150)
    private DentistaDto dentista;

    @Schema(description = "Nome do paciente",
            example = "Lucas neto",
            title = "Nome do paciente",
            maxLength = 150)
    private PacienteDto paciente;

    @Schema(description = "Pagamento",
            example = "200.00",
            title = "pagamento")
    private PagamentoDto pagamento;
}
