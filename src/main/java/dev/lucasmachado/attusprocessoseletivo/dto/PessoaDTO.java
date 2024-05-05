package dev.lucasmachado.attusprocessoseletivo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.lucasmachado.attusprocessoseletivo.model.Pessoa;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

public class PessoaDTO implements DefaultDTO<Pessoa> {
    private Long id;
    @NotEmpty(message = "")
    @Length(min = 3, max = 250)
    private String nomeCompleto;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotEmpty(message = "")
    private Date dataNascimento;

    public PessoaDTO(Long id, String nomeCompleto, Date dataNascimento) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
    }

    public PessoaDTO(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nomeCompleto = pessoa.getNomeCompleto();
        this.dataNascimento = pessoa.getDataNascimento();
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Pessoa toEntity() {
        return new Pessoa(this);
    }

}
