package br.com.example.amazon.amazon.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class IncluirUsuarioResponse {

    private String identify;
    private String nickName;
    private String email;
    private String image_perfil;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

}
