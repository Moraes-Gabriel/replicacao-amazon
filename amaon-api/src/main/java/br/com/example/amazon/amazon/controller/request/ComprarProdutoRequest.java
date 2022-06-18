package br.com.example.amazon.amazon.controller.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ComprarProdutoRequest {

    @NotBlank
    private Long produtoId;

    @NotBlank
    private Long quantidade;

    @NotBlank
    private Long CartaoId;

    @NotBlank
    private Long EnderecoId;


}
