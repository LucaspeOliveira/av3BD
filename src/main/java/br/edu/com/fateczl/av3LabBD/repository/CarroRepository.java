package br.edu.com.fateczl.av3LabBD.repository;

import br.edu.com.fateczl.av3LabBD.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, String> {

    // UDF com cursor para listar disponíveis
    @Query(value = "SELECT * FROM dbo.fn_ListarCarrosDisponiveis()", nativeQuery = true)
    List<Carro> listarCarrosDisponiveis();
}
