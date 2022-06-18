package br.com.example.amazon.amazon.service.produto;

import br.com.example.amazon.amazon.controller.response.ProdutoResponse;
import br.com.example.amazon.amazon.mapper.ProdutoMapper;
import br.com.example.amazon.amazon.model.Produto;
import br.com.example.amazon.amazon.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.example.amazon.amazon.mapper.ProdutoMapper.toResponsePage;

@Service
public class PesquisarProdutoPorNome {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Page<ProdutoResponse> pesquisar(String produtoNome, Pageable pageable) {

        Page<Produto> produtos = produtoRepository.findProdutoByNomeStartingWithIgnoreCase(produtoNome, pageable);

        return toResponsePage(produtos.getContent(), produtos.getPageable(), produtos.getTotalElements());

    }
}
