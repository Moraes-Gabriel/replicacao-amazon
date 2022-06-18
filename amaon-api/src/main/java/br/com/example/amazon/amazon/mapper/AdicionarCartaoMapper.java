package br.com.example.amazon.amazon.mapper;

import br.com.example.amazon.amazon.controller.request.AdicionarCartaoRequest;
import br.com.example.amazon.amazon.controller.request.AdicionarEnderecoRequeSt;
import br.com.example.amazon.amazon.model.CartaoCredito;
import br.com.example.amazon.amazon.model.Endereco;
import org.modelmapper.ModelMapper;

public class AdicionarCartaoMapper {

    public static CartaoCredito toEntity(AdicionarCartaoRequest request) {
        return new ModelMapper().map(request, CartaoCredito.class);
    }
}
