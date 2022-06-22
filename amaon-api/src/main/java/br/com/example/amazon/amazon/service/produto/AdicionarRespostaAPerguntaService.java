package br.com.example.amazon.amazon.service.produto;

import br.com.example.amazon.amazon.controller.request.AdicionarRespostaAPerguntaRequest;
import br.com.example.amazon.amazon.model.PerguntaProduto;
import br.com.example.amazon.amazon.model.RespostaPerguntaProduto;
import br.com.example.amazon.amazon.model.Usuario;
import br.com.example.amazon.amazon.repository.PerguntaProdutoRepository;
import br.com.example.amazon.amazon.service.buscar.BuscarPerguntaDoProdutoService;
import br.com.example.amazon.amazon.service.security.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AdicionarRespostaAPerguntaService {

    @Autowired
    private PerguntaProdutoRepository perguntaProdutoRepository;

    @Autowired
    private BuscarPerguntaDoProdutoService buscarPerguntaDoProdutoService;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    public void responder(AdicionarRespostaAPerguntaRequest request, Long perguntaId) {

        PerguntaProduto pergunta = buscarPerguntaDoProdutoService.porId(perguntaId);
        Usuario usuario = usuarioAutenticadoService.get();
        RespostaPerguntaProduto resposta = RespostaPerguntaProduto.builder()
                .resposta(request.getResposta())
                .data(LocalDate.now())
                .usuario(usuario)
                .build();

        perguntaProdutoRepository.save(pergunta);
    }
}
