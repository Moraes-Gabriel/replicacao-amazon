package br.com.example.amazon.amazon.service.produto;

import br.com.example.amazon.amazon.model.Produto;
import br.com.example.amazon.amazon.model.Usuario;
import br.com.example.amazon.amazon.repository.ProdutoRepository;
import br.com.example.amazon.amazon.repository.UsuarioRepository;
import br.com.example.amazon.amazon.service.buscar.BuscarProdutoService;
import br.com.example.amazon.amazon.service.security.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class AdicionarProdutoCarrinho {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private BuscarProdutoService buscarProdutoService;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    public void adicionar(Long produtoId) {

        Usuario usuario = usuarioAutenticadoService.get();
        Produto produto = buscarProdutoService.porId(produtoId);

        usuario.getCarrinho().add(produto);

        usuarioRepository.save(usuario);
    }
}
