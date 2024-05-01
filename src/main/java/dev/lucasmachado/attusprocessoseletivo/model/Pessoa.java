package dev.lucasmachado.attusprocessoseletivo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pessoas")
public class Pessoa extends AbstractEntity {

    private String nomeCompleto;

    @OneToMany(mappedBy="pessoa")
    private List<Endereco> enderecos = new ArrayList<>();

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public static final class Builder  {

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

        public Pessoa build(){
            return entity;
        }

    }

}
