package dev.lucasmachado.attusprocessoseletivo.factories;

import dev.lucasmachado.attusprocessoseletivo.model.Endereco;
import dev.lucasmachado.attusprocessoseletivo.repositories.EnderecoRepository;

public class EnderecoFactory {

    public static Endereco enderecoPadrao() {
        return Endereco.Builder.create()
                .CEP(88708071)
                .logradouro("Manoel Jovencio")
                .numero(133)
                .build();
    }

    public static Endereco enderecoPrincipal() {
        return Endereco.Builder.create()
                .CEP(88708071)
                .logradouro("Manoel Jovencio")
                .numero(133)
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
