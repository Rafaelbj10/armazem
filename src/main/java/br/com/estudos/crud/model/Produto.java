package br.com.estudos.crud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private double valorUnitario;
    private int quantidade;
    private String marca;
    private String descricao;

    public Produto(String nome, double valorUnitario, String marca) {
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.marca = marca;
    }
}
