package br.com.example.amazon.amazon.mapper;

import br.com.example.amazon.amazon.controller.request.AdicionarEnderecoRequeSt;
import br.com.example.amazon.amazon.model.Endereco;
import org.modelmapper.ModelMapper;

public class AdicionarEnderecoMapper {

    public static Endereco toEntity(AdicionarEnderecoRequeSt request) {
        return new ModelMapper().map(request, Endereco.class);
    }
}
