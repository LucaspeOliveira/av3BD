package br.edu.com.fateczl.av3LabBD.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarroDTO {
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private int ano;
    private String combustivel;
    private BigDecimal kmRodados;
    private String cambio;
    private String status;
    private Long categoriaId;
}
