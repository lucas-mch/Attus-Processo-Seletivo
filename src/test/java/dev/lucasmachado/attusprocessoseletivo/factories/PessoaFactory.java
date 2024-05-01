package dev.lucasmachado.attusprocessoseletivo.factories;

import dev.lucasmachado.attusprocessoseletivo.model.Pessoa;

public class PessoaFactory {

    public static Pessoa newPessoa() {
        return Pessoa.Builder.create()
                .id(null)
                .nomeCompleto("Mikhail Tal")
                .build();
    }
}