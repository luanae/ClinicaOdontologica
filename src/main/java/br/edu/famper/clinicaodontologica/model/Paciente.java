package br.edu.famper.clinicaodontologica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "paciente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", length = 100)
    @NotNull(message = "Preencha o campo Nome!")
    private String nome;

    @Column(name = "cpf", length = 20)
    @NotNull(message = "Preencha o campo Cpf!")
    @Size(min = 11, max = 11, message = "Cpf deve ter 11 caracteres")
    private String cpf;

    @Column(name = "endereco", length = 150)
    @NotNull(message = "Preencha o campo Endereço!")
    private String endereco;

    @Column(name = "telefone", length = 20)
    @NotNull(message = "Preencha o campo Telefone!")
    private String telefone;

    @Column(name = "email", length = 150)
    @NotNull(message = "Preencha o campo E-mail!")
    private String email;

    @OneToMany(mappedBy = "paciente",
            targetEntity = Consulta.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Consulta> consultas;

}
