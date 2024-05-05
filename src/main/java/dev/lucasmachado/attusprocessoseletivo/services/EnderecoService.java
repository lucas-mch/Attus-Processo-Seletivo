package dev.lucasmachado.attusprocessoseletivo.services;

import dev.lucasmachado.attusprocessoseletivo.model.Endereco;
import dev.lucasmachado.attusprocessoseletivo.model.Pessoa;
import dev.lucasmachado.attusprocessoseletivo.repositories.EnderecoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EnderecoService implements BasicService<Endereco> {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PessoaService pessoaService;

    @Override
    public Endereco save(Endereco e) {
        return enderecoRepository.save(e);
    }

    @Override
    public Endereco findById(Long id) {
        return enderecoRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Endereco> findAll(List<Long> ids) {
        return enderecoRepository.findAllById(ids);
    }

    @Override
    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    @Override
    public Endereco update(Endereco e) {
        return enderecoRepository.save(e);
    }

    @Override
    public List<Endereco> saveAll(List<Endereco> enderecos) {
        return enderecoRepository.saveAll(enderecos);
    }

    public Endereco savePrincipal(Long enderecoId, Long pessoaId) {
        Endereco enderecoTarget = this.findById(enderecoId);
        Pessoa pessoaTarget = pessoaService.findById(pessoaId);

        if(canBePrincipal(enderecoTarget, pessoaTarget)) {
            enderecoRepository.resetEnderecoPrincipal(pessoaId);
            enderecoTarget.setPessoa(pessoaTarget);
            enderecoTarget.setPrincipal(true);
        } else {
            throw new ValidationException("Por favor, verifique os dados de entrada. O endereço informado está atribuido á uma pessoa diferente do que foi informado na requisição.");
        }
        return enderecoRepository.save(enderecoTarget);
    }

    public Endereco saveToPessoa(Endereco endereco, Long pessoaId) {
        Pessoa pessoa = pessoaService.findById(pessoaId);
        endereco.setPessoa(pessoa);
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> findAllFromPessoa(Long id) {
        return enderecoRepository.findAllFromPessoa(id);
    }

    private boolean canBePrincipal(Endereco enderecoTarget, Pessoa pessoaTarget) {
        return Objects.isNull(enderecoTarget.getPessoa()) && Objects.nonNull(pessoaTarget) || enderecoTarget.getPessoa().getId().equals(pessoaTarget.getId());
    }
}
