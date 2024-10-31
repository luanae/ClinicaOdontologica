package br.edu.famper.clinicaodontologica.repository;

import br.edu.famper.clinicaodontologica.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
