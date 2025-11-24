package br.edu.com.fateczl.av3LabBD.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOCarro {
	
    private String placa;
    private String marca;
    private String modelo;
    private String status; // DISPONIVEL, ALUGADO e REPARO
    private int ano;
    private String cor;
    private String combustivel;
    private double kmRodando;
    private String cambio;
    private long categoriaId;
}
