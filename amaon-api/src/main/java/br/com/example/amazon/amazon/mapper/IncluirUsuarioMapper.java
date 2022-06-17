package br.com.example.amazon.amazon.mapper;

import br.com.example.amazon.amazon.controller.request.IncluirUsuarioRequest;
import br.com.example.amazon.amazon.controller.response.IncluirUsuarioResponse;
import br.com.example.amazon.amazon.model.Usuario;
import org.modelmapper.ModelMapper;

public class IncluirUsuarioMapper {

    public static Usuario toEntity(IncluirUsuarioRequest request) {
        return new ModelMapper().map(request, Usuario.class);
    }

    public static IncluirUsuarioResponse toResponse(Usuario entity) {
        return new ModelMapper().map(entity, IncluirUsuarioResponse.class);
    }

}
