package br.edu.com.fateczl.av3LabBD.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_reparos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reparo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "carro_placa", nullable = false)
    private Carro carro;

    @Column(name = "data_entrada", nullable = false)
    private LocalDate dataEntrada;

    @Column(name = "dias_reparo", nullable = false)
    private int diasReparo;

    @Column(name = "descricao", length = 255, nullable = false)
    private String descricao;

    @Column(name = "valor_reparo", precision = 10, scale = 2, nullable = false)
    private BigDecimal valorReparo;

    @Column(name = "data_conclusao", nullable = false)
    private LocalDate dataConclusao;
}
