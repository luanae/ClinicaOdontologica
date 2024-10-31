package br.edu.famper.clinicaodontologica.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idTratamento")
public class Tratamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTratamento;

    @Column(name = "descricao", length = 100)
    private String descricao;

    @Column(name = "dataInicio")
    private Date dataInicio;

    @Column(name = "dataFim")
    private Date dataFim;
}
