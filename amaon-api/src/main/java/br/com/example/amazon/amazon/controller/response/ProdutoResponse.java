package br.com.example.amazon.amazon.controller.response;

import br.com.example.amazon.amazon.model.AvaliacaoProduto;
import br.com.example.amazon.amazon.model.CategoriaProduto;
import br.com.example.amazon.amazon.model.PerguntaProduto;
import br.com.example.amazon.amazon.model.Usuario;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class ProdutoResponse {


    private Long id;
    private String nome;
    private CategoriaProduto categoria;
    private Double preco;
    private Long quantidadeProduto;
    private Double nota;
    private int quantidadeAvaliacoes;
    private int quantidadePerguntas;
    private List<String> imagens;
}
