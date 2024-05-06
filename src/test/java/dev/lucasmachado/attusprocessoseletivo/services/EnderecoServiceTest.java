package dev.lucasmachado.attusprocessoseletivo.services;

import dev.lucasmachado.attusprocessoseletivo.AttusProcessoSeletivoApplication;

import dev.lucasmachado.attusprocessoseletivo.factories.EnderecoFactory;
import dev.lucasmachado.attusprocessoseletivo.factories.PessoaFactory;
import dev.lucasmachado.attusprocessoseletivo.model.Endereco;
import dev.lucasmachado.attusprocessoseletivo.model.Pessoa;

import jakarta.validation.ValidationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = AttusProcessoSeletivoApplication.class)
@ComponentScan("dev.lucasmachado.attusprocessoseletivo")
public class EnderecoServiceTest {

    @Autowired
    private EnderecoService enderecoService;
    @Autowired
    private PessoaService pessoaService;

    @Test
    public void deveCriarEnderecoParaPessoa() {
        Endereco enderecoParaSalvar = EnderecoFactory.enderecoPadrao();
        Pessoa paraVincularEndereco = pessoaService.findById(1L);

        Endereco enderecoSalvo = enderecoService.saveToPessoa(enderecoParaSalvar, paraVincularEndereco.getId());

        Assert.assertEquals(enderecoSalvo.getCEP(), enderecoParaSalvar.getCEP());
        Assert.assertNotNull(enderecoSalvo.getPessoa());
    }

    @Test
    public void deveEditarUmEndereco() {
        Endereco enderecoParaEditar = enderecoService.findById(1L);
        enderecoParaEditar.setCep(88708071);

        Endereco enderecoEditado = enderecoService.update(enderecoParaEditar);

        Assert.assertEquals(enderecoParaEditar.getCEP(), enderecoEditado.getCEP());
    }

    @Test
    public void deveConsultarEnderecoPelaPessoa() {
        Endereco enderecoConsultado = enderecoService.findById(1L);
        Assert.assertNotNull(enderecoConsultado);
    }

    @Test
    public void deveConsultarEnderecosDeMultiplasPessoas() {
        List<Long> ids = Arrays.asList(1L, 2L, 3L);
        List<Endereco> enderecosConsultados = enderecoService.findAll(ids);

        Assert.assertNotNull(enderecosConsultados);
        Assert.assertEquals(enderecosConsultados.size(), ids.size());
    }

    @Test
    public void deveTornarEnderecoPrincipal() {
        Endereco enderecoSalvoComoPrincipal = enderecoService.savePrincipal(1L, 1L);
        Assertions.assertTrue(enderecoSalvoComoPrincipal.getPrincipal());
    }

    @Test
    public void naoDeveTornarEnderecoPrincipalDeOutraPessoa() {
        Pessoa primeiraPessoa = pessoaService.save(PessoaFactory.pessoaPadrao("Antonio"));
        Pessoa segundaPessoa = pessoaService.save(PessoaFactory.pessoaPadrao("Geraldinho"));

        Endereco enderecoDaPrimeiraPessoa = EnderecoFactory.enderecoPadrao();
        enderecoDaPrimeiraPessoa = enderecoService.saveToPessoa(enderecoDaPrimeiraPessoa, primeiraPessoa.getId());

        Endereco finalEnderecoDaPrimeiraPessoa = enderecoDaPrimeiraPessoa;

        ValidationException ex = Assertions.assertThrows(ValidationException.class, () ->
                enderecoService.savePrincipal(finalEnderecoDaPrimeiraPessoa.getId(), segundaPessoa.getId())
        );

        Assertions.assertNotNull(ex);
        Assertions.assertEquals(ex.getMessage(), "Por favor, verifique os dados de entrada. O endereço informado está atribuido á uma pessoa diferente do que foi informado na requisição.");

    }


}
