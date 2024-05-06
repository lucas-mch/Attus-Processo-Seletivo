package dev.lucasmachado.attusprocessoseletivo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.lucasmachado.attusprocessoseletivo.model.Pessoa;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PessoaDTO implements DefaultDTO<Pessoa, PessoaDTO> {
    private Long id;
    @NotEmpty(message = "")
    @Length(min = 3, max = 250)
    private String nomeCompleto;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Past
    @NotNull
    private Date dataNascimento;

    public PessoaDTO() {
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public Pessoa toEntity() {
        return new Pessoa(this);
    }

    @Override
    public PessoaDTO from(Pessoa pessoa) {
        BeanUtils.copyProperties(pessoa, this, "id");
        return this;
    }

    @Override
    public List<PessoaDTO> fromList(List<Pessoa> pessoaList) {
        List<PessoaDTO> convertedList = new ArrayList<>();
        pessoaList.forEach(entity -> {
            convertedList.add(new PessoaDTO().from(entity));
        });
        return convertedList;
    }

}
