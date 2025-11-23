package br.edu.com.fateczl.av3LabBD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.com.fateczl.av3LabBD.model.Carro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface RepositoryCarro extends JpaRepository<Carro, String>{

	@Query("SELECT c FROM carros c WHERE c.status = :status")
	List<Carro> listarCarroPorStatus(@Param("status") String status);
	
}
