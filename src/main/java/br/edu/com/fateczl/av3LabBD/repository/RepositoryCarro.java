package br.edu.com.fateczl.av3LabBD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.com.fateczl.av3LabBD.model.Carro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RepositoryCarro extends JpaRepository<Carro, String>{
	
	// UDF com cursor para listar disponíveis
	@Query(value = "SELECT * FROM dbo.fn_ListarCarrosDisponiveis()", nativeQuery = true)
	List<Carro> listarCarrosDisponiveis();
	
	// Fazer busca por categoria
    @Query(value = "SELECT * FROM tb_carros WHERE categoriaId = :categoriaId", nativeQuery = true)
    List<Carro> listarCarrosPorCategoria(@Param("categoriaId") Long categoriaID);
    

}
