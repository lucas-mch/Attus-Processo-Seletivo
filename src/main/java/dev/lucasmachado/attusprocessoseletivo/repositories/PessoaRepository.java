package dev.lucasmachado.attusprocessoseletivo.repositories;

import dev.lucasmachado.attusprocessoseletivo.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
}