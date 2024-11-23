package br.edu.famper.clinicaodontologica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "dentista")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Dentista {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", length = 100)
    @NotNull(message = "Preencha o campo Nome!")
    private String nome;

    @Column(name = "cpf_cnpj", length = 20)
    @NotNull(message = "Preencha o campo com cpf ou cnpj valido!")
    @Size(min = 11, max = 11, message = "Deve ter ao menos 11 caracteres")
    private String cpf_cnpj;

    @Column(name = "endereco", length = 100)
    @NotNull(message = "Preencha o campo Endereço!")
    private String endereco;

    @Column(name = "telefone", length = 20)
    @NotNull(message = "Preencha o campo Telefone!")
    private String telefone;

    @Column(name = "email", length = 150)
    @NotNull(message = "Preencha o campo E-mail!")
    private String email;

    @OneToMany(mappedBy = "dentista",
            targetEntity = Consulta.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Consulta> consultas;

}
