package br.com.estudos.crud.service;

import br.com.estudos.crud.model.Produto;
import br.com.estudos.crud.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public List<Produto> listar(){
        return produtoRepository.findAll();
    }


    public Optional<Produto> buscar(@PathVariable Long id){
        return produtoRepository.findById(id);
    }


    public Produto cadastrar(@RequestBody Produto produto){
        produtoRepository.save(produto);
        return produto;
    }


    public void alterar(@RequestBody Produto imput, @PathVariable Long id){
        Optional<Produto> produtoOpcional = produtoRepository.findById(id);
        if (produtoOpcional.isPresent()){
            Produto entity = produtoOpcional.get();
            entity.setNome(imput.getNome());
            entity.setValorUnitario(imput.getValorUnitario());
            entity.setMarca(imput.getMarca());
            entity.setQuantidade(imput.getQuantidade());

            produtoRepository.save(entity);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não existe no banco");
        }
    }


    public void deletar(@PathVariable Long id){
        produtoRepository.deleteById(id);
    }

}
