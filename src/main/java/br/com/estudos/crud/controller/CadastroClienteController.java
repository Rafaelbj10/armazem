package br.com.estudos.crud.controller;

import br.com.estudos.crud.dto.ClienteDto;
import br.com.estudos.crud.mapper.ClienteMapper;
import br.com.estudos.crud.model.Cliente;
import br.com.estudos.crud.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class ClienteController {

    @Autowired
    ClienteService clienteService;


    @GetMapping
    public List<ClienteDto> listar(){

        List<Cliente> cliente = clienteService.listar();

        ClienteMapper clienteMapper = new ClienteMapper();

        return clienteMapper.getUsuariosDtoByForEachNormal(cliente);

    }

    @GetMapping("/{id}")
    public List<ClienteDto> buscar(@PathVariable Long id){

        List<Cliente> cliente = clienteService.listar();
        List<ClienteDto> clienteDto = new ArrayList<>();

        for (Cliente u : cliente){

            ClienteDto dto = new ClienteDto();
            dto.setId(u.getId());
            dto.setNome(u.getNome());
            dto.setEndereco(u.getEndereco());

            clienteDto.add(dto);
        }
        return clienteDto;
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrar(@RequestBody ClienteDto clienteDto){
        Cliente cliente = clienteService.cadastrar(clienteDto.transformaParaObjeto());
        return new ResponseEntity(clienteDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterar(@RequestBody ClienteDto clienteDto, @PathVariable Long id){
        clienteService.alterar(clienteDto.transformaParaObjeto(), id);
        return new ResponseEntity(clienteDto, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        clienteService.deletar(id);
    }




}
