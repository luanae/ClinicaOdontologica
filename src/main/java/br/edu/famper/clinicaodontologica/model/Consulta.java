package br.edu.famper.clinicaodontologica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "descricao", length = 150)
    @NotNull(message = "Preencha o campo Descrição!")
    private String descricao;

    @Column(name = "valor")
    @NotNull(message = "Preencha o campo Valor!")
    private Double valor;

    @Column(name = "data_hora")
    @NotNull(message = "Preencha o campo data e hora!")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    @ManyToOne
    @JoinColumn(name = "dentistaId")
    private Dentista dentista;

    @ManyToOne
    @JoinColumn(name = "pacienteId")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "pagamentoId")
    private Pagamento pagamento;

    @OneToOne(mappedBy = "consulta",
            targetEntity = Pagamento.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private Pagamento pagamentos;

}
