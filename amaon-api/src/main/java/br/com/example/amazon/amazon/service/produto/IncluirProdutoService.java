package br.com.example.amazon.amazon.service.produto;

import br.com.example.amazon.amazon.controller.request.IncluirProdutoRequest;
import br.com.example.amazon.amazon.mapper.IncluirProdutoMapper;
import br.com.example.amazon.amazon.model.Produto;
import br.com.example.amazon.amazon.model.Usuario;
import br.com.example.amazon.amazon.repository.ProdutoRepository;
import br.com.example.amazon.amazon.service.security.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.example.amazon.amazon.mapper.IncluirProdutoMapper.toEntity;

@Service
public class IncluirProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    public void incluir(IncluirProdutoRequest request) {

        Usuario usuario = usuarioAutenticadoService.get();

        Produto produto = toEntity(request);

        produto.setQuantidadeProduto(0L);
        produto.setNota(0.0);
        produto.setUsuario(usuario);

        produtoRepository.save(produto);
    }
}
