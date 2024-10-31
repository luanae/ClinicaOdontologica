package br.edu.famper.clinicaodontologica.repository;

import br.edu.famper.clinicaodontologica.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
