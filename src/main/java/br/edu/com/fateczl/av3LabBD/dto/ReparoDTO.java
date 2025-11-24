package br.edu.com.fateczl.av3LabBD.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReparoDTO {
    private Long id;
    private String carroPlaca;
    private LocalDate dataEntrada;
    private int diasReparo;
    private String descricao;
    private BigDecimal valorReparo;
    private LocalDate dataConclusao;
}
