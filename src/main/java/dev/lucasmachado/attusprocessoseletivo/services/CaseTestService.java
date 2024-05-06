package dev.lucasmachado.attusprocessoseletivo.services;

import dev.lucasmachado.attusprocessoseletivo.repositories.EnderecoRepository;
import dev.lucasmachado.attusprocessoseletivo.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static dev.lucasmachado.attusprocessoseletivo.factories.EnderecoFactory.enderecoPadrao;
import static dev.lucasmachado.attusprocessoseletivo.factories.PessoaFactory.pessoaPadrao;

@Service
public class CaseTestService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public void initializeCaseTests() {
        populatePessoaTable();
        populateEnderecoTable();
    }

    public void populatePessoaTable() {
        pessoaRepository.save(pessoaPadrao(null));
        pessoaRepository.save(pessoaPadrao("Lucas"));
        pessoaRepository.save(pessoaPadrao("Rodolfo"));
    }
    public void populateEnderecoTable() {
        enderecoRepository.save(enderecoPadrao());
        enderecoRepository.save(enderecoPadrao());
        enderecoRepository.save(enderecoPadrao());
    }

}
