package br.edu.com.fateczl.av3LabBD.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_carros")
@Data
public class Carro {

    @Id
    private String placa; // chave primária da tabela

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
    private Categoria categoriaId; // relacionamento com tabela de categorias
}
    
