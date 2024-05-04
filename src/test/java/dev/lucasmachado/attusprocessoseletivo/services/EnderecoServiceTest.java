package dev.lucasmachado.attusprocessoseletivo.services;

import dev.lucasmachado.attusprocessoseletivo.AttusProcessoSeletivoApplication;
import dev.lucasmachado.attusprocessoseletivo.factories.EnderecoFactory;
import dev.lucasmachado.attusprocessoseletivo.model.Endereco;
import dev.lucasmachado.attusprocessoseletivo.model.Pessoa;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = AttusProcessoSeletivoApplication.class)
public class EnderecoServiceTest {

    @Autowired
    private EnderecoService enderecoService;
    @Autowired
    private PessoaService pessoaService;

    @Test
    public void deveCriarEnderecoParaPessoa() {
        Endereco enderecoParaSalvar = EnderecoFactory.enderecoPadrao();
        Pessoa paraVincularEndereco = pessoaService.find(1L);

        Endereco enderecoSalvo = enderecoService.saveToPessoa(enderecoParaSalvar, paraVincularEndereco.getId());

        Assert.assertEquals(enderecoSalvo.getCEP(), enderecoParaSalvar.getCEP());
        Assert.assertEquals(enderecoSalvo.getPessoa().getId(), paraVincularEndereco.getId());
    }

    @Test
    public void deveEditarUmEndereco() {
        Endereco enderecoParaEditar = enderecoService.find(1L);
        enderecoParaEditar.setCEP(88708071);

        Endereco enderecoEditado = enderecoService.update(enderecoParaEditar);

        Assert.assertEquals(enderecoParaEditar.getCEP(), enderecoEditado.getCEP());
    }

    @Test
    public void deveConsultarEnderecoPelaPessoa() {
        Endereco enderecoConsultado = enderecoService.find(1L);
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
        Endereco enderecoPrincipal = EnderecoFactory.enderecoPrincipal();
        Pessoa pessoaParaTornarEnderecoPrincipal = pessoaService.find(1L);
        Endereco enderecoSalvoComoPrincipal = enderecoService.principal(enderecoPrincipal, 1L);
    }

    @Test
    public void naoDeveCriarEnderecoSemCep() {
        Endereco enderecoSemCep = EnderecoFactory.enderecoSemCep();

        MethodArgumentNotValidException ex = Assertions.assertThrows(MethodArgumentNotValidException.class,() -> enderecoService.save(enderecoSemCep));

        Assertions.assertNotNull(ex);
    }

    @Test
    public void naoDeveCriarEnderecoSemLogradouro() {
        Endereco enderecoSemLogradouro = EnderecoFactory.enderecoSemLogradouro();

        MethodArgumentNotValidException ex = Assertions.assertThrows(MethodArgumentNotValidException.class,() -> enderecoService.save(enderecoSemLogradouro));

        Assertions.assertNotNull(ex);
    }
}
