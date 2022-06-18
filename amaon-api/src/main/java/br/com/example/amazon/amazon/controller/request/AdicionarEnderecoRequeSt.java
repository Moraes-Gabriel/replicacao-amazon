package br.com.example.amazon.amazon.controller.request;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Data
public class AdicionarEnderecoRequeSt {


    @NotBlank
    private String nomeCompleto;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    @NotBlank
    private String endereco;

    @NotBlank
    private Long numeroDaResidencia;

    @NotBlank
    private String complemento;

    @NotBlank
    private String bairro;

    @NotBlank
    private String cidade;

    @NotBlank
    private String estado;


}
