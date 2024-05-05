package dev.lucasmachado.attusprocessoseletivo.services;

import dev.lucasmachado.attusprocessoseletivo.dto.PessoaDTO;
import dev.lucasmachado.attusprocessoseletivo.model.Pessoa;
import dev.lucasmachado.attusprocessoseletivo.repositories.PessoaRepository;
import jakarta.validation.Valid;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService implements BasicService<PessoaDTO> {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public PessoaDTO save(PessoaDTO e) {
        return pessoaRepository.save(e.toEntity()).toDTO();
    }

    @Override
    public PessoaDTO findById(Long id) {
        Pessoa pessoaEncontrada = pessoaRepository.findById(id).orElseThrow();
        return pessoaEncontrada.toDTO();
    }

    @Override
    public List<PessoaDTO> findAll(List<Long> ids) {
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
    public List<Pessoa> saveAll(List<Pessoa> pessoas) {
        return pessoaRepository.saveAll(pessoas);
    }
}
