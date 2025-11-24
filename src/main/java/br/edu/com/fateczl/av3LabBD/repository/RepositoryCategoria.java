package br.edu.com.fateczl.av3LabBD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.com.fateczl.av3LabBD.model.Categoria;

public interface RepositoryCategoria extends JpaRepository<Categoria, Long> {
}
