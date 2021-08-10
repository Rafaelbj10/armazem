package br.com.estudos.crud.dto;

import br.com.estudos.crud.model.Produto;
import lombok.Data;

@Data
public class ProdutoDto {

    private Long id;
    private String nome;
    private double valorUnitario;
    private String marca;
    private String descricao;

    public Produto transformaParaObjeto(){
        return new Produto(id, nome, valorUnitario, marca, descricao);
    }

    public Long getId() {
        return id;
    }

    public ProdutoDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public ProdutoDto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public ProdutoDto setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
        return this;
    }

    public String getMarca() {
        return marca;
    }

    public ProdutoDto setMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public ProdutoDto setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }
}
