package br.com.example.amazon.amazon.service.produto;

import br.com.example.amazon.amazon.controller.request.AdicionarPerguntaAoProdutoRequest;
import br.com.example.amazon.amazon.model.PerguntaProduto;
import br.com.example.amazon.amazon.model.Produto;
import br.com.example.amazon.amazon.model.Usuario;
import br.com.example.amazon.amazon.repository.ProdutoRepository;
import br.com.example.amazon.amazon.service.buscar.BuscarProdutoService;
import br.com.example.amazon.amazon.service.security.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AdicionarPerguntaAoProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private BuscarProdutoService buscarProdutoService;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    public void adicionar(AdicionarPerguntaAoProdutoRequest request, Long produtoId) {

        Produto produto = buscarProdutoService.porId(produtoId);
        Usuario usuario = usuarioAutenticadoService.get();

        PerguntaProduto pergunta = PerguntaProduto.builder()
                .pergunta(request.getPergunta())
                .data(LocalDate.now())
                .usuario(usuario)
                .build();

        produto.getPerguntas().add(pergunta);

        produtoRepository.save(produto);
    }
}
