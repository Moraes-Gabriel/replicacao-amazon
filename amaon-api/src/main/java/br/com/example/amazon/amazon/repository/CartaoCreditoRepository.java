package br.com.example.amazon.amazon.repository;

import br.com.example.amazon.amazon.model.Carrinho;
import br.com.example.amazon.amazon.model.CartaoCredito;
import br.com.example.amazon.amazon.model.Produto;
import br.com.example.amazon.amazon.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoCreditoRepository extends JpaRepository<CartaoCredito, Long> {
}
