package br.com.estudos.crud.service;

import br.com.estudos.crud.parameters.ClienteRequest;
import br.com.estudos.crud.presenters.cliente.ClienteDto;

public interface CadastroClienteService {

    void cadastrar(ClienteRequest request);

    ClienteDto buscar(String cpf);

}
