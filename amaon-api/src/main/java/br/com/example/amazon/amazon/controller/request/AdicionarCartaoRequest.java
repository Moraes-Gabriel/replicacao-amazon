package br.com.example.amazon.amazon.controller.request;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class AdicionarCartaoRequest {

    @NotBlank
    private String numeroDoCartao;

    @NotBlank
    private String nomeDoCartao;

    @NotBlank
    private LocalDate dataDeExpiracao;

    @NotBlank
    private String codigoDeSeguranca;

}
