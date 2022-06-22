package br.com.example.amazon.amazon.service.produto.avaliacao;

import br.com.example.amazon.amazon.controller.request.AvaliarProdutoRequest;
import br.com.example.amazon.amazon.model.AvaliacaoProduto;
import br.com.example.amazon.amazon.model.Carrinho;
import br.com.example.amazon.amazon.model.Produto;
import br.com.example.amazon.amazon.model.Usuario;
import br.com.example.amazon.amazon.repository.CarrinhoRepository;
import br.com.example.amazon.amazon.repository.ProdutoRepository;
import br.com.example.amazon.amazon.service.buscar.BuscarProdutoService;
import br.com.example.amazon.amazon.service.security.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvaliarProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private BuscarProdutoService buscarProdutoService;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public void avaliar(AvaliarProdutoRequest request, Long produtoId) {

        Produto produto = buscarProdutoService.porId(produtoId);
        Usuario usuario = usuarioAutenticadoService.get();

        Carrinho carrinho = carrinhoRepository.findByUsuarioAndProduto(usuario, produto);

        if(carrinho == null) {
            throw new RuntimeException("voce nao tem pode realizar essa funcao.");
        }

        AvaliacaoProduto avaliacao = AvaliacaoProduto.builder()
                .titulo(request.getTitulo())
                .descricao(request.getDescricao())
                .nota(request.getNota())
                .usuario(usuario)
                .build();

        aumentarNotaProduto(produto, request.getNota());
        produto.getAvaliacao().add(avaliacao);
        produtoRepository.save(produto);
    }
    private void aumentarNotaProduto(Produto produto, Double nota){

        int quantidadeAvaliacoes = produto.getAvaliacao().size();
        Double notaTotal = produto.getNota() * quantidadeAvaliacoes;
        notaTotal += nota;

        Double notaMedia = notaTotal / (quantidadeAvaliacoes + 1 );

        produto.setNota(notaMedia);
    }
}
