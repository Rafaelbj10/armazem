package br.com.estudos.crud.mapper;

import br.com.estudos.crud.dto.ProdutoDto;
import br.com.estudos.crud.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoMapper {


    public List<ProdutoDto> getProdutosDtoByForEachNormal( List<Produto> produtoList){

        List<ProdutoDto> produtoDto = new ArrayList<>();

        for (Produto p : produtoList){

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

    public List<ProdutoDto> getProdutosDtoByFor(List<Produto> listaDeProdutos) {

        // Uma lista de produtos vazia para que você preencha ela com os produtos que for pegando no caso os DTOS
        List<ProdutoDto> produtoDto = new ArrayList<>();

        // A minha lista tem 3 produtos cadastrados
        for (int item = 0; item < listaDeProdutos.size(); item++) {

            // Pega pra mim o produto que esteja com o item de numero acima
            Produto produto = listaDeProdutos.get(item);

            ProdutoDto dto = new ProdutoDto();

            dto.setId(produto.getId());
            dto.setNome(produto.getNome());
            dto.setMarca(produto.getMarca());
            dto.setValorUnitario(produto.getValorUnitario());
            dto.setDescricao(produto.getDescricao());

            produtoDto.add(dto);
        }

        return produtoDto;

    }


    public List<ProdutoDto> getProdutosDtoByForStream(List<Produto> produtoList) {

        List<ProdutoDto> listaProdutoDto = new ArrayList<>();

        // Pega a lista de produtos, coloca em uma esteira e (PARA CADA = forEach) produto
        produtoList.stream().forEach(produto -> {

            ProdutoDto dto = new ProdutoDto();
            dto.setId(produto.getId());
            dto.setNome(produto.getNome());
            dto.setMarca(produto.getMarca());
            dto.setValorUnitario(produto.getValorUnitario());
            dto.setDescricao(produto.getDescricao());

            listaProdutoDto.add(dto);

        });

        return listaProdutoDto;
    }
}
