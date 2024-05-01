package dev.lucasmachado.attusprocessoseletivo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private List<Endereco> enderecos = new ArrayList<>();


}
