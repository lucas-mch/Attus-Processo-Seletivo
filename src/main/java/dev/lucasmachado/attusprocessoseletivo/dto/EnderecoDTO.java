package dev.lucasmachado.attusprocessoseletivo.dto;

import dev.lucasmachado.attusprocessoseletivo.model.Endereco;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class EnderecoDTO implements DefaultDTO<Endereco, EnderecoDTO> {

    @NotEmpty(message = "O endereço precisa ter um Logradouro")
    @Length(min = 5, max = 80, message = "O tamanho deve ser entre 5 a 80 caracteres.")
    private String logradouro;
    @NotNull(message = "O endereço precisa ter um cep")
    @Positive
    private Integer cep;
    @NotNull(message = "O endereço precisa ter um número")
    @Positive
    private Integer numero;
    @NotEmpty(message = "O endereço precisa ter uma Cidade")
    @Length(min = 5, max = 80, message = "O tamanho deve ser entre 5 a 80 caracteres.")
    private String cidade;
    @NotEmpty(message = "O endereço precisa ter um Estado")
    @Length(min = 5, max = 80, message = "O tamanho deve ser entre 5 a 80 caracteres.")
    private String estado;

    public EnderecoDTO() {
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public Endereco toEntity() {
        return new Endereco(this);
    }

    @Override
    public EnderecoDTO from(Endereco e) {
        BeanUtils.copyProperties(e, this, "id");
        return this;
    }

    @Override
    public List<EnderecoDTO> fromList(List<Endereco> e) {
        List<EnderecoDTO> convertedList = new ArrayList<>();
        e.forEach(endereco -> {
            convertedList.add(new EnderecoDTO().from(endereco));
        });
        return convertedList;
    }
}
