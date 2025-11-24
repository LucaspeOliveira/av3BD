package br.edu.com.fateczl.av3LabBD.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.edu.com.fateczl.av3LabBD.dto.DTOCarro;
import br.edu.com.fateczl.av3LabBD.model.Carro;
import br.edu.com.fateczl.av3LabBD.model.Categoria;
import br.edu.com.fateczl.av3LabBD.repository.RepositoryCarro;
import br.edu.com.fateczl.av3LabBD.repository.RepositoryCategoria;

@Service
public class ServiceCarro {

    private final RepositoryCarro carroRepository;
    private final RepositoryCategoria categoriaRepository;

    public ServiceCarro(RepositoryCarro carroRepository, RepositoryCategoria categoriaRepository) {
        this.carroRepository = carroRepository;
        this.categoriaRepository = categoriaRepository;
    }

    // Conversão: Carro -> DTOCarro
    private DTOCarro toDTO(Carro carro) {
        DTOCarro dto = new DTOCarro();
        dto.setPlaca(carro.getPlaca());
        dto.setMarca(carro.getMarca());
        dto.setModelo(carro.getModelo());
        dto.setStatus(carro.getStatus());
        dto.setAno(carro.getAno());
        dto.setCor(carro.getCor());
        dto.setCombustivel(carro.getCombustivel());
        dto.setKmRodando(carro.getKmRodando());
        dto.setCambio(carro.getCambio());
        dto.setCategoriaId(carro.getCategoria() != null ? carro.getCategoria().getId() : null);
        return dto;
    }

    // Conversão: DTOCarro -> Carro
    private Carro toEntity(DTOCarro dto) {
        Carro carro = new Carro();
        carro.setPlaca(dto.getPlaca());
        carro.setMarca(dto.getMarca());
        carro.setModelo(dto.getModelo());
        carro.setStatus(dto.getStatus());
        carro.setAno(dto.getAno());
        carro.setCor(dto.getCor());
        carro.setCombustivel(dto.getCombustivel());
        carro.setKmRodando(dto.getKmRodando());
        carro.setCambio(dto.getCambio());

        if (dto.getCategoriaId() != 0) {
            Categoria categoria = categoriaRepository.findById(dto.getCategoriaId()).orElse(null);
            carro.setCategoria(categoria);
        }

        return carro;
    }

    // Listar todos os carros (DTO)
    public List<DTOCarro> listarTodosCarros() {
        return carroRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Salvar carro a partir de DTO
    public DTOCarro salvar(DTOCarro dto) {
        Carro carro = toEntity(dto);
        Carro salvo = carroRepository.save(carro);
        return toDTO(salvo);
    }

    // Remover carro pela placa
    public void remover(String placa) {
        carroRepository.deleteById(placa);
    }

    // Buscar carro por placa
    public DTOCarro buscarPorPlaca(String placa) {
        return carroRepository.findById(placa)
                .map(this::toDTO)
                .orElse(null);
    }
    
    public List<DTOCarro> listarCarrosDisponiveis() {
        return carroRepository.findAll()
                .stream()
                .filter(c -> "DISPONIVEL".equalsIgnoreCase(c.getStatus()))
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
