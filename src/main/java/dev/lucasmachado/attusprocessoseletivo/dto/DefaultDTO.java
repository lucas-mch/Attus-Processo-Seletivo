package dev.lucasmachado.attusprocessoseletivo.dto;

import dev.lucasmachado.attusprocessoseletivo.model.Pessoa;

import java.io.Serializable;
import java.util.List;

public interface DefaultDTO<Entity,DTO extends DefaultDTO<Entity, DTO>> extends Serializable {
    Entity toEntity();
    DTO convert(Entity e);
    List<DTO> convertToList(List<Entity> e);

}
