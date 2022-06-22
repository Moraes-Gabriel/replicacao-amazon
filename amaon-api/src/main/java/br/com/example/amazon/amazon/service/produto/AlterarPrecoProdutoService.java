package br.com.example.amazon.amazon.service.produto;

import br.com.example.amazon.amazon.controller.request.AlterarPrecoDoProdutoRequest;
import br.com.example.amazon.amazon.model.Produto;
import br.com.example.amazon.amazon.repository.ProdutoRepository;
import br.com.example.amazon.amazon.service.buscar.BuscarProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlterarPrecoProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private BuscarProdutoService buscarProdutoService;


    public void alterar(AlterarPrecoDoProdutoRequest request, Long produtoId) {

        Produto produto = buscarProdutoService.porId(produtoId);

        produto.setPreco(request.getPreco());

        produtoRepository.save(produto);
    }
}
