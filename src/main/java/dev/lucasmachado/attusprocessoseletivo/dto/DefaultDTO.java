package dev.lucasmachado.attusprocessoseletivo.dto;

import java.io.Serializable;

public interface DefaultDTO<Entity> extends Serializable {
    Entity toEntity();
}
