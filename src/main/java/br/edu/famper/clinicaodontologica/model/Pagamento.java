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
@EqualsAndHashCode(of = "idPagamento")

public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPagamento;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "dataPagamento")
    private Date dataPagamento;

    @Column(name = "nome", length = 100)
    private String formaPagamento;

    @ManyToOne
    @JoinColumn(name = "idConsulta")
    private Pagamento pagamento;  //chave estrangeira
}
