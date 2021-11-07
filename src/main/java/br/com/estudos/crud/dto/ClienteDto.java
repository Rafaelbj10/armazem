package br.com.estudos.crud.dto;

import br.com.estudos.crud.model.Usuario;
import lombok.Data;

@Data
public class UsuarioDto {

    private Long id;
    private String nome;
    private String endereco;

    public Usuario transformaParaObjeto(){
        return new Usuario(id, nome, endereco);
    }


    public Long getId() {
        return id;
    }

    public UsuarioDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public UsuarioDto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getEndereco() {
        return endereco;
    }

    public UsuarioDto setEndereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

    @Override
    public String toString() {
        return "UsuarioDto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
