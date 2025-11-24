package br.edu.com.fateczl.av3LabBD.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.edu.com.fateczl.av3LabBD.model.Categoria;
import br.edu.com.fateczl.av3LabBD.repository.RepositoryCategoria;

@Service
public class ServiceCategoria {

    private final RepositoryCategoria repository;

    public ServiceCategoria(RepositoryCategoria repository) {
        this.repository = repository;
    }

    public List<Categoria> listarTodas() {
        return repository.findAll();
    }

    public Categoria salvar(Categoria categoria) {
        return repository.save(categoria);
    }

    public Categoria buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }
}
