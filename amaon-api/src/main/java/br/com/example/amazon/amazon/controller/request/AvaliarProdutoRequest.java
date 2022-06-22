package br.com.example.amazon.amazon.controller.request;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class AvaliarProdutoRequest {

    private String titulo;

    private String descricao;

    @NotBlank
    private Double nota;

}
