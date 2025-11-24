package br.edu.com.fateczl.av3LabBD.model;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_carros")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carro {

    @Id
    @Column(name = "placa", length = 10, nullable = false)
    private String placa;

    @Column(name = "marca", length = 100, nullable = false)
    private String marca;

    @Column(name = "modelo", length = 100, nullable = false)
    private String modelo;

    @Column(name = "cor", length = 50, nullable = false)
    private String cor;

    @Column(name = "ano", nullable = false)
    private int ano;

    @Column(name = "combustivel", length = 10, nullable = false)
    private String combustivel;

    @Column(name = "km_rodados", precision = 10, scale = 2, nullable = false)
    private BigDecimal kmRodados;

    @Column(name = "cambio", length = 8, nullable = false)
    private String cambio;

    @Column(name = "status", length = 10, nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;
}

    
