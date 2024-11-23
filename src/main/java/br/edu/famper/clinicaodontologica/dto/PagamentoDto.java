package br.edu.famper.clinicaodontologica.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jdk.jfr.Description;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PagamentoDto {

    @Schema(description = "Id do pagamento",
            example = "1",
            title = "id")
    private Long id;

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

}
