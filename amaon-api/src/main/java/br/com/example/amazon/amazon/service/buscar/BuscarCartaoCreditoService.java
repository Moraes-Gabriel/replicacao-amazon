package br.com.example.amazon.amazon.service.buscar;

import br.com.example.amazon.amazon.model.CartaoCredito;
import br.com.example.amazon.amazon.repository.CartaoCreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class BuscarCartaoCreditoService {

    @Autowired
    private CartaoCreditoRepository repository;

    public CartaoCredito porId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Cartao credito não encontrado"));
    }
}
