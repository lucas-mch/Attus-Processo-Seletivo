package dev.lucasmachado.attusprocessoseletivo.services;

import jakarta.validation.Valid;

import java.util.List;

public interface BasicService<EntityDTO> {
    EntityDTO save(@Valid EntityDTO dto);

    EntityDTO findById(Long id);

    List<EntityDTO> findAll(List<Long> ids);
    List<EntityDTO> findAll();

    EntityDTO update(@Valid EntityDTO dto);

    List<EntityDTO> saveAll(List<@Valid EntityDTO> entities);
}
