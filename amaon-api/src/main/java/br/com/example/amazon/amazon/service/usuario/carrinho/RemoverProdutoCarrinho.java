package br.com.example.amazon.amazon.service.usuario.carrinho;

import br.com.example.amazon.amazon.model.Carrinho;
import br.com.example.amazon.amazon.model.Produto;
import br.com.example.amazon.amazon.model.Usuario;
import br.com.example.amazon.amazon.repository.CarrinhoRepository;
import br.com.example.amazon.amazon.repository.ProdutoRepository;
import br.com.example.amazon.amazon.repository.UsuarioRepository;
import br.com.example.amazon.amazon.service.buscar.BuscarProdutoService;
import br.com.example.amazon.amazon.service.security.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RemoverProdutoCarrinho {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private BuscarProdutoService buscarProdutoService;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    public void remover(Long produtoId) {

        Usuario usuario = usuarioAutenticadoService.get();
        Produto produto = buscarProdutoService.porId(produtoId);

        Carrinho carrinho = carrinhoRepository.findByUsuarioAndProduto(usuario, produto);

        Double valorCarrinhoProdutosRemovidos =
                carrinho.getProduto().getPreco() * carrinho.getQuantidadeProdutos();

        Double valorTotalCarrinhoUsuario = usuario.getCarrinho().getValorTotal();
        valorTotalCarrinhoUsuario -= valorCarrinhoProdutosRemovidos;


        usuario.getCarrinho().setValorTotal(valorTotalCarrinhoUsuario);
        usuario.getCarrinho().getCarrinho().remove(carrinho);

        usuarioRepository.save(usuario);
    }
}
