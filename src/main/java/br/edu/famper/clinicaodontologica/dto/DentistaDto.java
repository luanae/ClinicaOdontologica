package br.edu.famper.clinicaodontologica.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class DentistaDto {

    @Schema(description = "Id do dentista",
            example = "1",
            title = "id")
    private Long id;

    @Schema(description = "Nome do dentista",
            example = "Coloridinho da Silva",
            title = "nome",
            maxLength = 100)
    private String nome;

    @Schema(description = "Cpf ou cnpj do dentista",
            example = "191.381.932-02",
            title = "cpf_cnpj",
            maxLength = 20)
    private String cpf_cnpj;

    @Schema(description = "E-mail do dentista",
            example = "coloridinhodasilvaoficial@gmail.com",
            title = "e-mail",
            maxLength = 150)
    private String email;

    @Schema(description = "Telefone do dentista",
            example = "48 999128310",
            title = "telefone",
            maxLength = 20)
    private String telefone;

    @Schema(description = "Endereco do dentista",
            example = "Rua Paulo 2",
            title = "endereco",
            maxLength = 150)
    private String endereco;

    @Schema(description = "Descrição da consulta",
            example = "Dente podre",
            title = "descricao consulta",
            maxLength = 100)
    private ConsultaDto consulta;
}
