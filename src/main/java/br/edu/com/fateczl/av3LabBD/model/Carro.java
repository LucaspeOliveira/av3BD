package br.edu.com.fateczl.av3LabBD.model;

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
    @Column(length = 10) 
    private String placa;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String status; // DISPONIVEL, ALUGADO, etc.
    
    @Column(nullable = false)
    private int ano;
    
    @Column(nullable = false)
    private String cor;
    
    @Column(nullable = false)
    private String combustivel;
    
    @Column(nullable = false)
    private double kmRodando;
    
    @Column(nullable = false)
    private String cambio;

    @ManyToOne
    @JoinColumn(name = "categoriaId", nullable = false)
    private Categoria categoria; // relacionamento com tabela de categorias
}
    
