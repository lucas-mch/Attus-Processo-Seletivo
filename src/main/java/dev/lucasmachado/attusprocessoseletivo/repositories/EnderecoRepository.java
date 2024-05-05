package dev.lucasmachado.attusprocessoseletivo.repositories;

import dev.lucasmachado.attusprocessoseletivo.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Long> {
    @Query("SELECT DISTINCT adress FROM Endereco adress INNER JOIN adress.pessoa pes where adress.pessoa.id = :id")
    List<Endereco> findAllFromPessoa(Long id);

    @Query("SELECT DISTINCT adress FROM Endereco adress INNER JOIN adress.pessoa pes where adress.pessoa.id in(:ids)")
    List<Endereco> findAllFromPessoas(List<Long> ids);

    @Modifying
    @Query("UPDATE Endereco adress SET adress.isPrincipal = false where adress.pessoa.id = :id")
    void resetEnderecoPrincipal(Long id);

    @Query("SELECT DISTINCT adress FROM Endereco adress INNER JOIN adress.pessoa pes where adress.pessoa.id = :id and adress.isPrincipal is true")
    List<Endereco> findPrincipalFromPessoa(Long id);

}
