package br.com.example.amazon.amazon.mapper;

import br.com.example.amazon.amazon.controller.response.ProdutoResponse;
import br.com.example.amazon.amazon.model.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

public class ProdutoMapper {

    public static ProdutoResponse toResponse(Produto entity) {
         ProdutoResponse response =  new ModelMapper().map(entity, ProdutoResponse.class);
         response.setQuantidadeAvaliacoes(entity.getAvaliacao().size());
         response.setQuantidadePerguntas(entity.getPerguntas().size());

         return response;
    }
    public static Page<ProdutoResponse> toResponsePage(List<Produto> lista, Pageable pageable, Long total){
        List<ProdutoResponse> response = lista.stream().map(ProdutoMapper::toResponse).
                collect(Collectors.toList());

        return new PageImpl<ProdutoResponse>(response, pageable, total);
    }
}
