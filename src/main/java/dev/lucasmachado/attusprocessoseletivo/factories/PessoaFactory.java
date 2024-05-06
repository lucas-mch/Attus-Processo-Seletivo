package dev.lucasmachado.attusprocessoseletivo.factories;

import dev.lucasmachado.attusprocessoseletivo.model.Pessoa;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class PessoaFactory {

    public static Pessoa pessoaPadrao(String customName) {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1970);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);

        return Pessoa.Builder.create()
                .nomeCompleto(Objects.nonNull(customName) ? customName : "Mikhail Tal")
                .dataNascimento(cal.getTime())
                .build();
    }
    public static Pessoa pessoaSemNome() {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1970);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);

        return Pessoa.Builder.create()
                .nomeCompleto(null)
                .dataNascimento(cal.getTime())
                .build();
    }
    public static Pessoa pessoaSemDataNascimento() {

        Calendar cal = Calendar.getInstance();

        return Pessoa.Builder.create()
                .nomeCompleto("Mikhail Tal")
                .dataNascimento(null)
                .build();
    }

    public static Date customDataAniversario(Integer dia, Integer mes, Integer ano) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, dia);
        cal.set(Calendar.MONTH, mes);
        cal.set(Calendar.YEAR, ano);
        return cal.getTime();
    }

}
