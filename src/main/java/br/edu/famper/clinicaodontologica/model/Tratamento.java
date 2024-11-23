package br.edu.famper.clinicaodontologica.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tratamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "descricao", length = 100)
    @NotNull(message = "Preencha o campo Descrição!")
    private String descricao;

    @Column(name = "dataInicio")
    @NotNull(message = "Preencha o campo Data de inicio!")
    private Date dataInicio;

    @Column(name = "dataFim")
    @NotNull(message = "Preencha o campo Data final!")
    private Date dataFim;
}
