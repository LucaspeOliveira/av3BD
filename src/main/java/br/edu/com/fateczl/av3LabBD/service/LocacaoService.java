package br.edu.com.fateczl.av3LabBD.service;

import br.edu.com.fateczl.av3LabBD.dto.LocacaoDTO;
import br.edu.com.fateczl.av3LabBD.model.Locacao;
import br.edu.com.fateczl.av3LabBD.repository.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocacaoService {

    @Autowired
    private LocacaoRepository locacaoRepository;

    public void salvar(LocacaoDTO dto) {
        Locacao locacao = toEntity(dto);
        locacaoRepository.save(locacao);
    }

    public List<LocacaoDTO> listarTodos() {
        return locacaoRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public void deletar(Long id) {
        locacaoRepository.deleteById(id);
    }

    private Locacao toEntity(LocacaoDTO dto) {
        Locacao locacao = new Locacao();
        locacao.setId(dto.getId());
        // aqui você precisa buscar o Carro e Cliente pelo id/cpf/placa
        // Exemplo: locacao.setCarro(carroRepository.findById(dto.getCarroPlaca()).orElse(null));
        // locacao.setCliente(clienteRepository.findById(dto.getClienteCpf()).orElse(null));
        locacao.setDataRetirada(dto.getDataRetirada());
        locacao.setDiasAlugado(dto.getDiasAlugado());
        locacao.setDataDevolucao(dto.getDataDevolucao());
        locacao.setTanque(dto.getTanque());
        locacao.setValorTotal(dto.getValorTotal());
        return locacao;
    }

    private LocacaoDTO toDTO(Locacao locacao) {
        LocacaoDTO dto = new LocacaoDTO();
        dto.setId(locacao.getId());
        dto.setCarroPlaca(locacao.getCarro().getPlaca());
        dto.setClienteCpf(locacao.getCliente().getCpf());
        dto.setDataRetirada(locacao.getDataRetirada());
        dto.setDiasAlugado(locacao.getDiasAlugado());
        dto.setDataDevolucao(locacao.getDataDevolucao());
        dto.setTanque(locacao.getTanque());
        dto.setValorTotal(locacao.getValorTotal());
        return dto;
    }
}
