package br.com.example.amazon.amazon.controller.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AlterarPrecoDoProdutoRequest {

    @NotBlank
    private Double preco;
}
