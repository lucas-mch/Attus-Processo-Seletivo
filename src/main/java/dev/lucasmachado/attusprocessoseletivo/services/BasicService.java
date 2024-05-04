package dev.lucasmachado.attusprocessoseletivo.services;

import jakarta.validation.Valid;

import java.util.List;

public interface BasicService<Entity> {
    Entity save(@Valid Entity e);

    Entity find(Long id);

    List<Entity> findAll(List<Long> ids);

    Entity update(@Valid Entity e);

    List<Entity> saveAll(List<@Valid Entity> entities);
}
