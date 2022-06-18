package br.com.example.amazon.amazon.repository;

import br.com.example.amazon.amazon.model.Carrinho;
import br.com.example.amazon.amazon.model.Endereco;
import br.com.example.amazon.amazon.model.Produto;
import br.com.example.amazon.amazon.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
