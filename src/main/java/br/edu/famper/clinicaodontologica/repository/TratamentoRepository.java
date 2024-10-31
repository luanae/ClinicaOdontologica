package br.edu.famper.clinicaodontologica.repository;

import br.edu.famper.clinicaodontologica.model.Tratamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TratamentoRepository extends JpaRepository<Tratamento, Long> {
}
