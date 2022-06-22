package br.com.example.amazon.amazon.repository;

import br.com.example.amazon.amazon.model.PerguntaProduto;
import br.com.example.amazon.amazon.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerguntaProdutoRepository extends JpaRepository<PerguntaProduto, Long> {


}
