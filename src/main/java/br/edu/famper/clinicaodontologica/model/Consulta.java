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
@EqualsAndHashCode(of = "idConsulta")

public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idConsulta;

    @Column(name = "descricao", length = 150)
    private String descricao;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "data_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    @ManyToOne
    @JoinColumn(name = "idDentista")
    private Dentista dentista;

    @ManyToOne
    @JoinColumn(name = "idPaciente")
    private Paciente paciente;
}
