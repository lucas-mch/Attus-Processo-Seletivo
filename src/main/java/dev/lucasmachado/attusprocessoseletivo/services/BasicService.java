package dev.lucasmachado.attusprocessoseletivo.services;

import jakarta.validation.Valid;

import java.util.List;

public interface BasicService<Entity> {
    Entity save(@Valid Entity entity);

    Entity findById(Long id);

    List<Entity> findAll(List<Long> ids);
    List<Entity> findAll();

    Entity update(@Valid Entity dto);

    List<Entity> saveAll(List<@Valid Entity> entities);
}
