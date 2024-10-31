package br.edu.famper.clinicaodontologica.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PacienteDto {

    @Schema(description = "Nome do paciente",
            example = "Lucas Neto",
            title = "nome",
            maxLength = 100)
    private String nome;

    @Schema(description = "Cpf do paciente",
            example = "109.721.931-91",
            title = "cpf",
            maxLength = 20)
    private String cpf;

    @Schema(description = "Endereco do paciente",
            example = "Linha Boa Nova",
            title = "endereco",
            maxLength = 150)
    private String endereco;

    @Schema(description = "Telefone do paciente",
            example = "45 999578192",
            title = "telefone",
            maxLength = 20)
    private String telefone;

    @Schema(description = "E-mail do paciente",
            example = "lucasneto@gmail.com",
            title = "e-mail",
            maxLength = 150)
    private String email;
}
