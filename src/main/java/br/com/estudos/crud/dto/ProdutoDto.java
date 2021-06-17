package br.com.estudos.crud.dto;

import br.com.estudos.crud.model.Produto;
import lombok.Data;



@Data
public class ProdutoDto {


    private String nome;
    private double valorUnitario;
    private String marca;

    public Produto transformaParaObjeto(){
        return new Produto(nome, valorUnitario, marca);
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
}
