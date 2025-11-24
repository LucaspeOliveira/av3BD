package br.edu.com.fateczl.av3LabBD.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoricoLocacaoDTO {
    private Long id;
    private String clienteCpf;
    private Long locacaoId;
    private LocalDate dataLocacao;
}
