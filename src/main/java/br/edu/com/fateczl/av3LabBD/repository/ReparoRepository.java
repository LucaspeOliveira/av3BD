package br.edu.com.fateczl.av3LabBD.repository;

import br.edu.com.fateczl.av3LabBD.model.Reparo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReparoRepository extends JpaRepository<Reparo, Long> {
}
