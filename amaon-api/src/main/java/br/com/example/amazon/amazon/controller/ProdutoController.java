package br.com.example.amazon.amazon.controller;

import br.com.example.amazon.amazon.controller.request.*;
import br.com.example.amazon.amazon.controller.response.ProdutoResponse;
import br.com.example.amazon.amazon.service.produto.IncluirProdutoService;
import br.com.example.amazon.amazon.service.produto.*;
import br.com.example.amazon.amazon.service.produto.avaliacao.AvaliarProdutoService;
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

    @Autowired
    private AdicionarPerguntaAoProdutoService adicionarPerguntaAoProdutoService;

    @Autowired
    private AdicionarRespostaAPerguntaService adicionarRespostaAPerguntaService;

    @Autowired
    private AlterarPrecoProdutoService alterarPrecoProdutoService;

    @Autowired
    private AvaliarProdutoService avaliarProdutoService;

    @Secured("ROLE_ADMIN")
    @PostMapping()
    public void incluir(@Valid @RequestBody IncluirProdutoRequest request) {
        incluirProdutoService.incluir(request);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/adicionar/quantidade/{produtoId}/{quantidadeProduto}")
    public void adicionarQuantidadeProduto(@PathVariable Long quantidadeProduto, Long produtoId) {
        adicionarQuantidadeDeProduto.adicionar(quantidadeProduto, produtoId);
    }

    @Secured("ROLE_USER")
    @GetMapping("/pesquisar/{produtoNome}")
    public Page<ProdutoResponse> pesquisarProduto(@PathVariable String produtoNome, Pageable pageable) {
        return pesquisarProdutoPorNome.pesquisar(produtoNome, pageable);
    }

    @PostMapping("/adicionar/pergunta/{produtoId}")
    @Secured("ROLE_USER")
    public void adicionarUmaPerguntaAoProduto(@Valid @RequestBody AdicionarPerguntaAoProdutoRequest request, @PathVariable Long produtoId){
        adicionarPerguntaAoProdutoService.adicionar(request, produtoId);
    }

    @PostMapping("/adicionar/resposta/pergunta/{perguntaId}")
    @Secured("ROLE_USER")
    public void adicionarUmaPerguntaAoProduto(@Valid @RequestBody AdicionarRespostaAPerguntaRequest request, @PathVariable Long perguntaId){
        adicionarRespostaAPerguntaService.responder(request, perguntaId);
    }

    @PostMapping("/alterar/preco/{produtoId}")
    @Secured("ROLE_ADMIN")
    public void alterarPrecoDoProduto(@Valid @RequestBody AlterarPrecoDoProdutoRequest request, @PathVariable Long produtoId){
        alterarPrecoProdutoService.alterar(request, produtoId);
    }

    @PostMapping("/avaliar/produto/{produtoId}")
    @Secured("ROLE_ADMIN")
    public void avaliarProduto(@Valid @RequestBody AvaliarProdutoRequest request, @PathVariable Long produtoId){
        avaliarProdutoService.avaliar(request, produtoId);
    }
}
