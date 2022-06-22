package br.com.example.amazon.amazon.service.buscar;

import br.com.example.amazon.amazon.model.PerguntaProduto;
import br.com.example.amazon.amazon.model.Produto;
import br.com.example.amazon.amazon.repository.PerguntaProdutoRepository;
import br.com.example.amazon.amazon.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class BuscarPerguntaDoProdutoService {

    @Autowired
    private PerguntaProdutoRepository repository;

    public PerguntaProduto porId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Pergunta não encontrada"));
    }
}
