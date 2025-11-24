package br.edu.com.fateczl.av3LabBD.service;

import br.edu.com.fateczl.av3LabBD.dto.ClienteDTO;
import br.edu.com.fateczl.av3LabBD.model.Cliente;
import br.edu.com.fateczl.av3LabBD.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Salvar ou atualizar cliente
    public void salvar(ClienteDTO dto) {
        Cliente cliente = toEntity(dto);
        clienteRepository.save(cliente);
    }

    // Listar todos os clientes
    public List<ClienteDTO> listarTodos() {
        return clienteRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Deletar cliente pelo CPF
    public void deletar(String cpf) {
        clienteRepository.deleteById(cpf);
    }

    // Conversão DTO → Entity
    private Cliente toEntity(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setCpf(dto.getCpf());
        cliente.setNome(dto.getNome());
        cliente.setNumeroHabilitacao(dto.getNumeroHabilitacao());
        cliente.setDataNascimento(dto.getDataNascimento());
        cliente.setLogradouro(dto.getLogradouro());
        cliente.setNumero(dto.getNumero());
        cliente.setCep(dto.getCep());
        cliente.setCidade(dto.getCidade());
        return cliente;
    }

    // Conversão Entity → DTO
    private ClienteDTO toDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setCpf(cliente.getCpf());
        dto.setNome(cliente.getNome());
        dto.setNumeroHabilitacao(cliente.getNumeroHabilitacao());
        dto.setDataNascimento(cliente.getDataNascimento());
        dto.setLogradouro(cliente.getLogradouro());
        dto.setNumero(cliente.getNumero());
        dto.setCep(cliente.getCep());
        dto.setCidade(cliente.getCidade());
        return dto;
    }
}
