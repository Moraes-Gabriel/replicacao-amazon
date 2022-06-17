package br.com.example.amazon.amazon.mapper;

import br.com.example.amazon.amazon.controller.request.IncluirProdutoRequest;
import br.com.example.amazon.amazon.controller.response.IncluirUsuarioResponse;
import br.com.example.amazon.amazon.model.Produto;
import br.com.example.amazon.amazon.model.Usuario;
import org.modelmapper.ModelMapper;

public class IncluirProdutoMapper {

    public static Produto toEntity(IncluirProdutoRequest request) {
        return new ModelMapper().map(request, Produto.class);
    }

    public static IncluirUsuarioResponse toResponse(Usuario entity) {
        return new ModelMapper().map(entity, IncluirUsuarioResponse.class);
    }

}
