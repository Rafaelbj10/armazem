package br.com.estudos.crud.controller;

import br.com.estudos.crud.dto.ProdutoDto;
import br.com.estudos.crud.model.Produto;
import br.com.estudos.crud.repository.ProdutoRepository;
import br.com.estudos.crud.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping
    public List<Produto> listar(){
        return produtoService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Produto> buscar(@PathVariable Long id){
        return produtoService.buscar(id);
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@RequestBody ProdutoDto dto){
        Produto produto = produtoService.cadastrar(dto.transformaParaObjeto());
        return new ResponseEntity<>(produto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public void alterar(@RequestBody Produto imput, @PathVariable Long id){
        produtoService.alterar(imput, id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        produtoService.deletar(id);
    }

}
