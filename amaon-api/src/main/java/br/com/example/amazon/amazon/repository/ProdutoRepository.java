package br.com.example.amazon.amazon.repository;

import br.com.example.amazon.amazon.model.Produto;
import br.com.example.amazon.amazon.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Page<Produto> findProdutoByNomeStartingWithIgnoreCase(String nome, Pageable pageable);


}
