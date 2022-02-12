package br.com.estudos.crud.controller.Impl;

import br.com.estudos.crud.controller.CadastroClienteController;
import br.com.estudos.crud.parameters.ClienteRequest;
import br.com.estudos.crud.presenters.cliente.ClienteDto;
import br.com.estudos.crud.presenters.cliente.ClienteResponse;
import br.com.estudos.crud.service.CadastroClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CadastroClienteControllerImpl implements CadastroClienteController {

    private final CadastroClienteService cadastroClienteService;

    public ResponseEntity<ClienteResponse> cadastrar(final ClienteRequest request) {
        cadastroClienteService.cadastrar(request);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ClienteDto> buscar(String cpf) {
        final var response = cadastroClienteService.buscar(cpf);
        return ResponseEntity.ok(response);
    }

}
