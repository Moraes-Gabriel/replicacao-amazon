package br.com.example.amazon.amazon.controller.request;

import br.com.example.amazon.amazon.model.Permissao;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class IncluirUsuarioRequest {

    @NotBlank
    private String nome;
    @NotBlank
    private String email;
    @NotBlank
    private String senha;

    private LocalDate birthDate;

}
