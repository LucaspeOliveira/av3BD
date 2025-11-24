package br.edu.com.fateczl.av3LabBD.service;

import br.edu.com.fateczl.av3LabBD.dto.CategoriaDTO;
import br.edu.com.fateczl.av3LabBD.model.Categoria;
import br.edu.com.fateczl.av3LabBD.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Salvar ou atualizar categoria
    public void salvar(CategoriaDTO dto) {
        Categoria categoria = toEntity(dto);
        categoriaRepository.save(categoria);
    }

    // Listar todas as categorias
    public List<CategoriaDTO> listarTodas() {
        return categoriaRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Deletar categoria pelo ID
    public void deletar(Long id) {
        categoriaRepository.deleteById(id);
    }

    // Converter DTO → Entity
    private Categoria toEntity(CategoriaDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setId(dto.getId());
        categoria.setNome(dto.getNome());
        categoria.setValorDiaria(dto.getValorDiaria());
        return categoria;
    }

    // Converter Entity → DTO
    private CategoriaDTO toDTO(Categoria categoria) {
        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(categoria.getId());
        dto.setNome(categoria.getNome());
        dto.setValorDiaria(categoria.getValorDiaria());
        return dto;
    }
}
