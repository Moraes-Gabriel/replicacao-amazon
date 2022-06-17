package br.com.example.amazon.amazon.controller.request;

import br.com.example.amazon.amazon.model.CategoriaProduto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class IncluirProdutoRequest {

    @NotBlank
    private String nome;

    @NotNull
    private CategoriaProduto category;

    @NotBlank
    private Double preco;

}
