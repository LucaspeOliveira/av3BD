package br.edu.com.fateczl.av3LabBD.repository;

import br.edu.com.fateczl.av3LabBD.model.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {
}
