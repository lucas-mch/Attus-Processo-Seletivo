package dev.lucasmachado.attusprocessoseletivo.services;

import dev.lucasmachado.attusprocessoseletivo.dto.PessoaDTO;
import dev.lucasmachado.attusprocessoseletivo.model.Pessoa;
import dev.lucasmachado.attusprocessoseletivo.repositories.PessoaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService implements BasicService<Pessoa> {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public Pessoa save(Pessoa p) {
        return pessoaRepository.save(p);
    }

    @Override
    public Pessoa findById(Long id) {
        return pessoaRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Pessoa> findAll(List<Long> ids) {
        return pessoaRepository.findAllById(ids);
    }

    @Override
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa update(Pessoa e) {
        return pessoaRepository.save(e);
    }

    @Override
    public List<Pessoa> saveAll(List<@Valid Pessoa> pessoas) {
        return pessoaRepository.saveAll(pessoas);
    }
}
