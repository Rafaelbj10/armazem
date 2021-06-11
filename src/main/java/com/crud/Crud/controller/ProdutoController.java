package com.crud.Crud.controller;

import com.crud.Crud.model.Produto;
import com.crud.Crud.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> listar(){
        return produtoRepository.findAll();
    }

    @PostMapping
    public void cadastrar(@RequestBody Produto produto){
        produtoRepository.save(produto);
    }

    @PutMapping
    public void alterar(@RequestBody Produto produto){
        produtoRepository.save(produto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        produtoRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<Produto> buscar(@PathVariable Long id){
        return produtoRepository.findById(id);
    }

}
