package br.edu.com.fateczl.av3LabBD.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocacaoDTO {
    private Long id;
    private String carroPlaca;
    private String clienteCpf;
    private LocalDate dataRetirada;
    private int diasAlugado;
    private LocalDate dataDevolucao;
    private String tanque;
    private BigDecimal valorTotal;
}
