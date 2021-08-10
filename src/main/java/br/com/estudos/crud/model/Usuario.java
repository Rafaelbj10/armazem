package br.com.estudos.crud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@NoArgsConstructor
@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String endereco;
    private Date dataNascimento;

    public Usuario(Long id, String nome, String endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
    }


}
