package br.edu.famper.clinicaodontologica.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TratamentoDto {

    @Schema(description = "Id do tratamento",
            example = "1",
            title = "id")
    private Long id;

    @Schema(description = "Descricao do tratamento",
            example = "sarna",
            title = "descricao",
            maxLength = 150)
    private String descricao;

    @Schema(description = "Data inicio do tratamento",
            example = "2024-01-02",
            title = "dataInicio",
            maxLength = 150)
    private Date dataInicio;

    @Schema(description = "Data final do tratamento",
            example = "2024-05-10",
            title = "dataFim",
            maxLength = 150)
    private Date dataFim;
}
