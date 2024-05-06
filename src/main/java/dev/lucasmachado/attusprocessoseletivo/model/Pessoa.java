package dev.lucasmachado.attusprocessoseletivo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.lucasmachado.attusprocessoseletivo.dto.PessoaDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pessoas")
public class Pessoa extends AbstractEntity<PessoaDTO> {

    @Column(name = "nome")
    private String nomeCompleto;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "data_nascimento")
    private Date dataNascimento;
    @OneToMany(mappedBy = "pessoa")
    private List<Endereco> enderecos = new ArrayList<>();

    public Pessoa() {
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

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }



    public Pessoa(PessoaDTO dto) {
        BeanUtils.copyProperties(dto, this, "id");
    }

    public static final class Builder {

        private Pessoa entity;

        private Builder(Pessoa entity) {
            this.entity = entity;
        }

        public static Builder create() {
            return new Builder(new Pessoa());
        }

        public Builder id(Long id) {
            entity.setId(id);
            return this;
        }

        public Builder nomeCompleto(String nomeCompleto) {
            entity.nomeCompleto = nomeCompleto;
            return this;
        }

        public Builder dataNascimento(Date dataNascimento) {
            entity.dataNascimento = dataNascimento;
            return this;
        }

        public Pessoa build() {
            return entity;
        }

    }

}
