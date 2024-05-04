package dev.lucasmachado.attusprocessoseletivo.services;

import dev.lucasmachado.attusprocessoseletivo.model.Pessoa;
import dev.lucasmachado.attusprocessoseletivo.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService implements BasicService<Pessoa> {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public Pessoa save(Pessoa e) {
        return pessoaRepository.save(e);
    }

    @Override
    public Pessoa find(Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public List<Pessoa> findAll(List<Long> ids) {
        return pessoaRepository.findAllById(ids);
    }

    @Override
    public Pessoa update(Pessoa e) {
        return pessoaRepository.save(e);
    }

    @Override
    public List<Pessoa> saveAll(List<Pessoa> pessoas) {
        return pessoaRepository.saveAll(pessoas);
    }
}
