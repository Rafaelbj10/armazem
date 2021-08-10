package br.com.estudos.crud.controller;

import br.com.estudos.crud.dto.ProdutoDto;
import br.com.estudos.crud.mapper.ProdutoMapper;
import br.com.estudos.crud.model.Produto;
import br.com.estudos.crud.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping
    public List<ProdutoDto> listar(){

        List<Produto> produtos = produtoService.listar();

        ProdutoMapper produtoMapper = new ProdutoMapper();

        //return produtoMapper.getProdutosDtoByForEachNormal(produtos);

        //return produtoMapper.getProdutosDtoByFor(produtos);

        return produtoMapper.getProdutosDtoByForStream(produtos);

    }

    @GetMapping("/{id}")
    public List<ProdutoDto> buscar(@PathVariable Long id){

        List<Produto> produtos = produtoService.listar();

        List<ProdutoDto> produtoDto = new ArrayList<>();

        for (Produto p : produtos){

            ProdutoDto dto = new ProdutoDto();

            dto.setId(p.getId());
            dto.setNome(p.getNome());
            dto.setMarca(p.getMarca());
            dto.setValorUnitario(p.getValorUnitario());
            dto.setDescricao(p.getDescricao());

            produtoDto.add(dto);
        }
        return produtoDto;

    }

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@RequestBody ProdutoDto dto){
        Produto produto = produtoService.cadastrar(dto.transformaParaObjeto());
        return new ResponseEntity(produto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterar(@RequestBody ProdutoDto dto, @PathVariable Long id){
        produtoService.alterar(dto.transformaParaObjeto(), id);
        return new ResponseEntity(dto, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        produtoService.deletar(id);
    }

}
