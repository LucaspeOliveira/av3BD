package br.edu.com.fateczl.av3LabBD.service;

import br.edu.com.fateczl.av3LabBD.dto.CarroDTO;
import br.edu.com.fateczl.av3LabBD.model.Carro;
import br.edu.com.fateczl.av3LabBD.model.Categoria;
import br.edu.com.fateczl.av3LabBD.repository.CarroRepository;
import br.edu.com.fateczl.av3LabBD.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Salvar ou atualizar carro
    public void salvar(CarroDTO dto) {
        Carro carro = toEntity(dto);
        carroRepository.save(carro);
    }

    // Listar todos os carros
    public List<CarroDTO> listarTodos() {
        return carroRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Listar carros disponíveis (via UDF)
    public List<CarroDTO> listarDisponiveis() {
        return carroRepository.listarCarrosDisponiveis()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Deletar carro pela placa
    public void deletar(String placa) {
        carroRepository.deleteById(placa);
    }

    // Converter DTO → Entity
    private Carro toEntity(CarroDTO dto) {
        Carro carro = new Carro();
        carro.setPlaca(dto.getPlaca());
        carro.setMarca(dto.getMarca());
        carro.setModelo(dto.getModelo());
        carro.setCor(dto.getCor());
        carro.setAno(dto.getAno());
        carro.setCombustivel(dto.getCombustivel());
        carro.setKmRodados(dto.getKmRodados());
        carro.setCambio(dto.getCambio());
        carro.setStatus(dto.getStatus());

        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new IllegalArgumentException("Categoria inválida"));
        carro.setCategoria(categoria);

        return carro;
    }

    // Converter Entity → DTO
    private CarroDTO toDTO(Carro carro) {
        CarroDTO dto = new CarroDTO();
        dto.setPlaca(carro.getPlaca());
        dto.setMarca(carro.getMarca());
        dto.setModelo(carro.getModelo());
        dto.setCor(carro.getCor());
        dto.setAno(carro.getAno());
        dto.setCombustivel(carro.getCombustivel());
        dto.setKmRodados(carro.getKmRodados());
        dto.setCambio(carro.getCambio());
        dto.setStatus(carro.getStatus());
        dto.setCategoriaId(carro.getCategoria().getId());
        dto.setCategoriaNome(carro.getCategoria().getNome());
        return dto;
    }
}
