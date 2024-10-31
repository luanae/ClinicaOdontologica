package br.edu.famper.clinicaodontologica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "dentista")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idDentista")

public class Dentista {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDentista;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "cpf_cnpj", length = 20)
    private String cpf_cnpj;

    @Column(name = "endereco", length = 100)
    private String endereco;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "email", length = 150)
    private String email;

    @OneToMany(mappedBy = "dentista",
            targetEntity = Consulta.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Consulta> consultas;
}
