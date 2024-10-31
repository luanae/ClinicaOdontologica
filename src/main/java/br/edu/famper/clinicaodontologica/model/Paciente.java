package br.edu.famper.clinicaodontologica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "paciente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idPaciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPaciente;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "cpf", length = 20)
    private String cpf;

    @Column(name = "endereco", length = 150)
    private String endereco;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "email", length = 150)
    private String email;

    @OneToMany(mappedBy = "paciente",
            targetEntity = Consulta.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Consulta> consultas;
}
