package dev.lucasmachado.attusprocessoseletivo.services;

import dev.lucasmachado.attusprocessoseletivo.model.Endereco;
import dev.lucasmachado.attusprocessoseletivo.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService implements BasicService<Endereco> {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public Endereco save(Endereco e) {
        return enderecoRepository.save(e);
    }

    @Override
    public Endereco find(Long id) {
        return enderecoRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Endereco> findAll(List<Long> ids) {
        return enderecoRepository.findAllById(ids);
    }

    @Override
    public Endereco update(Endereco e) {
        return enderecoRepository.save(e);
    }

    @Override
    public List<Endereco> saveAll(List<Endereco> enderecos) {
        return enderecoRepository.saveAll(enderecos);
    }

    public Endereco savePrincipal(Endereco endereco, Long id) {
        return enderecoRepository.save(endereco);
    }

    public Endereco saveToPessoa(Endereco endereco, Long id) {
        return enderecoRepository.save(endereco);
    }
}
