package dev.lucasmachado.attusprocessoseletivo.factories;

import dev.lucasmachado.attusprocessoseletivo.model.Endereco;
import dev.lucasmachado.attusprocessoseletivo.repositories.EnderecoRepository;

public class EnderecoFactory {

    public static Endereco enderecoPadrao() {
        return Endereco.Builder.create().build();
    }

    public static Endereco enderecoPrincipal() {
        return Endereco.Builder.create()
            .isPrincipal(true)
                .build();
    }

    public static Endereco enderecoSemCep() {
        return Endereco.Builder.create()
                .CEP(null)
                .build();
    }

    public static Endereco enderecoSemLogradouro() {
        return Endereco.Builder.create()
                .logradouro(null)
                .build();
    }

}
