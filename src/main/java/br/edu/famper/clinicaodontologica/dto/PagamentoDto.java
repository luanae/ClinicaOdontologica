package br.edu.famper.clinicaodontologica.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PagamentoDto {

    @Schema(description = "Valor da consulta",
            example = "200.00",
            title = "valor")
    private Double valor;

    @Schema(description = "Data do pagamento",
            example = "2024-04-10",
            title = "dataPagamento")
    private Date dataPagamento;

    @Schema(description = "Forma do pagamento",
            example = "Pix",
            title = "formaPagamento",
            maxLength = 20)
    private String formaPagamento;

    @Schema(description = "Consulta",
            example = "12",
            title = "consulta",
            maxLength = 150)
    private List<ConsultaDto> consulta;
}
