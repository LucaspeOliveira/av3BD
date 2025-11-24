package br.edu.com.fateczl.av3LabBD.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.com.fateczl.av3LabBD.dto.ReparoDTO;
import br.edu.com.fateczl.av3LabBD.model.Reparo;
import br.edu.com.fateczl.av3LabBD.repository.CarroRepository;
import br.edu.com.fateczl.av3LabBD.repository.ReparoRepository;


@Service
public class ReparoService {

    @Autowired
    private ReparoRepository reparoRepository;

    @Autowired
    private CarroRepository carroRepository;

    public void salvar(ReparoDTO dto) {
        Reparo reparo = toEntity(dto);
        reparoRepository.save(reparo);
    }

    public List<ReparoDTO> listarTodos() {
        return reparoRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public void deletar(Long id) {
        reparoRepository.deleteById(id);
    }

    private Reparo toEntity(ReparoDTO dto) {
        Reparo r = new Reparo();
        r.setId(dto.getId());
        r.setCarro(carroRepository.findById(dto.getCarroPlaca()).orElse(null));
        r.setDataEntrada(dto.getDataEntrada());
        r.setDiasReparo(dto.getDiasReparo());
        r.setDescricao(dto.getDescricao());
        r.setValorReparo(dto.getValorReparo());
        r.setDataConclusao(dto.getDataConclusao());
        return r;
    }

    private ReparoDTO toDTO(Reparo r) {
        ReparoDTO dto = new ReparoDTO();
        dto.setId(r.getId());
        dto.setCarroPlaca(r.getCarro().getPlaca());
        dto.setDataEntrada(r.getDataEntrada());
        dto.setDiasReparo(r.getDiasReparo());
        dto.setDescricao(r.getDescricao());
        dto.setValorReparo(r.getValorReparo());
        dto.setDataConclusao(r.getDataConclusao());
        return dto;
    }
}
