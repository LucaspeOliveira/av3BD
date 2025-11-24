package br.edu.com.fateczl.av3LabBD.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.com.fateczl.av3LabBD.dto.LocacaoDTO;
import br.edu.com.fateczl.av3LabBD.model.Locacao;
import br.edu.com.fateczl.av3LabBD.repository.LocacaoRepository;

@Service
public class HistoricoService {

    @Autowired
    private LocacaoRepository locacaoRepository;

    public List<LocacaoDTO> listarHistorico() {
        // exemplo: todas locações já devolvidas
        return locacaoRepository.findAll()
                .stream()
                .filter(l -> l.getDataDevolucao().isBefore(LocalDate.now()))
                .map(this::toDTO)
                .collect(Collectors.toList());
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
