package br.com.example.amazon.amazon.controller;

import br.com.example.amazon.amazon.controller.request.IncluirProdutoRequest;
import br.com.example.amazon.amazon.controller.response.ProdutoResponse;
import br.com.example.amazon.amazon.model.Produto;
import br.com.example.amazon.amazon.service.IncluirProdutoService;
import br.com.example.amazon.amazon.service.produto.AdicionarQuantidadeDeProduto;
import br.com.example.amazon.amazon.service.produto.PesquisarProdutoPorNome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private IncluirProdutoService incluirProdutoService;

    @Autowired
    private AdicionarQuantidadeDeProduto adicionarQuantidadeDeProduto;

    @Autowired
    private PesquisarProdutoPorNome pesquisarProdutoPorNome;

    @Secured("ADMIN")
    @PostMapping()
    public void incluir(@Valid @RequestBody IncluirProdutoRequest request) {
        incluirProdutoService.incluir(request);
    }

    @Secured("ADMIN")
    @PutMapping("/adicionar/quantidade/{produtoId}/{quantidadeProduto}")
    public void adicionarQuantidadeProduto(@PathVariable Long quantidadeProduto, Long produtoId) {
        adicionarQuantidadeDeProduto.adicionar(quantidadeProduto, produtoId);
    }

    @GetMapping("/pesquisar/{produtoNome}")
    public Page<ProdutoResponse> pesquisarProduto(@PathVariable String produtoNome, Pageable pageable) {
        return pesquisarProdutoPorNome.pesquisar(produtoNome, pageable);
    }
}
