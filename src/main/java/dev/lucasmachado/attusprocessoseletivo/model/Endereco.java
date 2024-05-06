package dev.lucasmachado.attusprocessoseletivo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.lucasmachado.attusprocessoseletivo.dto.EnderecoDTO;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "enderecos")
public class Endereco extends AbstractEntity<EnderecoDTO> {

    private String logradouro;
    private Integer cep;
    private Integer numero;
    private String estado;
    private String cidade;
    @Column(name = "fl_principal")
    private Boolean isPrincipal = Boolean.FALSE;
    @ManyToOne
    @JoinColumn(name = "i_pessoas", referencedColumnName = "id")
    private Pessoa pessoa;

    public Endereco() {
    }

    public Endereco(EnderecoDTO dto) {
        BeanUtils.copyProperties(dto, this, "id");
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getCEP() {
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

    public Boolean getPrincipal() {
        return isPrincipal;
    }

    public void setPrincipal(Boolean principal) {
        isPrincipal = principal;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public static final class Builder {

        protected Endereco entity;

        private Builder(Endereco entity) {
            this.entity = entity;
        }

        public static Builder create() {
            return new Builder(new Endereco());
        }

        public Builder id(Long id) {
            entity.setId(id);
            return this;
        }

        public Builder logradouro(String logradouro) {
            entity.logradouro = logradouro;
            return this;
        }

        public Builder CEP(Integer cep) {
            entity.cep = cep;
            return this;
        }

        public Builder numero(Integer numero) {
            entity.numero = numero;
            return this;
        }

        public Builder isPrincipal(Boolean isPrincipal) {
            entity.isPrincipal = isPrincipal;
            return this;
        }

        public Endereco build() {
            return entity;
        }

    }
}
