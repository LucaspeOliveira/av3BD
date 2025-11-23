package br.edu.com.fateczl.av3LabBD.service;

import br.edu.com.fateczl.av3LabBD.dto.DTOCarro;
import br.edu.com.fateczl.av3LabBD.model.Carro;
import br.edu.com.fateczl.av3LabBD.repository.RepositoryCarro;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceCarro {

    @Autowired
    private RepositoryCarro carroRepository;

    // CREATE
    @Transactional
    public String inserirCarro(DTOCarro dto) {
        Carro carro = new Carro();
        carro.setPlaca(dto.getPlaca());
        carro.setMarca(dto.getMarca());
        carro.setModelo(dto.getModelo());
        carro.setStatus(dto.getStatus());
        carro.setAno(dto.getAno());
        carro.setCor(dto.getCor());
        carro.setCambio(dto.getCambio());
        carro.setCombustivel(dto.getCombustivel());
        carro.setKmRodando(dto.getKmRodando());
        carro.setCategoriaId(dto.getCategoriaId());

        carroRepository.save(carro);
        return "Carro foi inserido com sucesso!";
    }

    // READ
    public DTOCarro buscarCarroPorPlaca(String placa) {
        Carro carro = carroRepository.findById(placa).orElseThrow(() -> new RuntimeException("Nao foi possivel encontrar o carro"));

        return new DTOCarro(
                carro.getPlaca(),
                carro.getMarca(),
                carro.getModelo(),
                carro.getStatus(),
                carro.getAno(),
                carro.getCor(),
                carro.getCombustivel(),
                carro.getKmRodando(),
                carro.getCambio(),
                carro.getCategoriaId()
        );
    }

    // UPDATE
    @Transactional
    public String atualizarCarro(DTOCarro dto) {
        Carro carro = carroRepository.findById(dto.getPlaca()).orElseThrow(() -> new RuntimeException("Nao foi possivel encontrar o carro"));

        if (dto.getCategoriaId() != null) carro.setCategoriaId(dto.getCategoriaId());
        if (dto.getMarca() != null) carro.setMarca(dto.getMarca());
        if (dto.getModelo() != null) carro.setModelo(dto.getModelo());
        if (dto.getAno() != 0) carro.setAno(dto.getAno());
        if (dto.getCor() != null) carro.setCor(dto.getCor());
        if (dto.getCombustivel() != null) carro.setCombustivel(dto.getCombustivel());
        if (dto.getKmRodando() != 0) carro.setKmRodando(dto.getKmRodando());
        if (dto.getCambio() != null) carro.setCambio(dto.getCambio());
        if (dto.getStatus() != null) carro.setStatus(dto.getStatus());
        
        carroRepository.save(carro);
        return "Carro modificado com sucesso!";
    }

    // DELETE
    @Transactional
    public String deletarCarro(String placa) {
        carroRepository.deleteById(placa);
        return "Carro deletado com sucesso!";
    }

    // LISTAR TODOS
    public List<DTOCarro> listarTodosCarros() {
        List<Carro> listaEntidades = carroRepository.findAll();
        List<DTOCarro> resposta = new ArrayList<>();

        for (Carro c : listaEntidades) {
            resposta.add(new DTOCarro(
            		c.getPlaca(),
                    c.getMarca(),
                    c.getModelo(),
                    c.getStatus(),
                    c.getAno(),
                    c.getCor(),
                    c.getCombustivel(),
                    c.getKmRodando(),
                    c.getCambio(),
                    c.getCategoriaId()
            ));
        }
        return resposta;
    }

    // READ por categoria
    public List<DTOCarro> listarCarrosPorCategoria(Long categoriaId) {
        List<Carro> lista = carroRepository.listarCarrosPorCategoria(categoriaId);
        List<DTOCarro> resposta = new ArrayList<>();

        for (Carro c : lista) {
            resposta.add(new DTOCarro(
            		c.getPlaca(),
                    c.getMarca(),
                    c.getModelo(),
                    c.getStatus(),
                    c.getAno(),
                    c.getCor(),
                    c.getCombustivel(),
                    c.getKmRodando(),
                    c.getCambio(),
                    c.getCategoriaId()
            ));
        }
        return resposta;
    }
}