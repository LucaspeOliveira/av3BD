package br.edu.com.fateczl.av3LabBD.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    private String cpf;
    private String nome;
    private String numeroHabilitacao;
    private LocalDate dataNascimento;
    private String logradouro;
    private int numero;
    private String cep;
    private String cidade;
}
