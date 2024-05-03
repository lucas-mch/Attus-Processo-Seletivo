package dev.lucasmachado.attusprocessoseletivo.factories;

import dev.lucasmachado.attusprocessoseletivo.model.Pessoa;

import java.util.Calendar;
import java.util.Objects;

public class PessoaFactory {

    public static Pessoa newPessoa(String nome, Integer dia, Integer mes, Integer ano) {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, Objects.nonNull(ano) ? ano : 1970);
        cal.set(Calendar.MONTH, Objects.nonNull(mes) ? mes : 0);
        cal.set(Calendar.DAY_OF_MONTH, Objects.nonNull(dia) ? dia : 1);

        return Pessoa.Builder.create()
                .nomeCompleto(Objects.nonNull(nome) ? nome : "Mikhail Tal")
                .dataNascimento(cal.getTime())
                .build();
    }

}
