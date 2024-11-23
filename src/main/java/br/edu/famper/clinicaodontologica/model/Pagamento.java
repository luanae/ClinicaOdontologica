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

public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "valor")
    @NotNull(message = "Preencha o campo Valor!")
    private Double valor;

    @Column(name = "dataPagamento")
    @NotNull(message = "Preencha o campo Data do Pagamento!")
    private Date dataPagamento;

    @Column(name = "formaPagamento", length = 100)
    @NotNull(message = "Preencha o campo Forma de pagamento!")
    private String formaPagamento;

    @OneToOne
    @JoinColumn(name = "consultaId")
    private Consulta consulta;
}
