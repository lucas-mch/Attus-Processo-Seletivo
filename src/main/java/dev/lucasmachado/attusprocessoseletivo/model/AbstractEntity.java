package dev.lucasmachado.attusprocessoseletivo.model;

import jakarta.persistence.*;

import java.util.Objects;

@MappedSuperclass
public abstract class AbstractEntity<Entity> implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public AbstractEntity() {
    }

    public AbstractEntity(Long id) {
        this.id = id;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }


}

