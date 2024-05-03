package dev.lucasmachado.attusprocessoseletivo.services;

import dev.lucasmachado.attusprocessoseletivo.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static dev.lucasmachado.attusprocessoseletivo.factories.PessoaFactory.newPessoa;

@Service
public class CaseTestService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public void initializeCaseTests() {
        populatePessoaTable();
    }

    public void populatePessoaTable() {
        pessoaRepository.save(newPessoa(null,null,null,null));
        pessoaRepository.save(newPessoa("Lucas",null,null,null));
        pessoaRepository.save(newPessoa("Rodolfo",null,null,null));
    }

}
