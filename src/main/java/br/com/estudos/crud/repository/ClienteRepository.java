package br.com.estudos.crud.repository;

import br.com.estudos.crud.parameters.ClienteRequest;
import br.com.estudos.crud.presenters.cliente.ClienteDto;

public interface ClienteRepository {

    void insertClient(ClienteRequest request);

    ClienteDto buscar(String cpf);


}

