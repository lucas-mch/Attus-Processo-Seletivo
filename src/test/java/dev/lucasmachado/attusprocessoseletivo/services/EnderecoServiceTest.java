package dev.lucasmachado.attusprocessoseletivo.services;

import dev.lucasmachado.attusprocessoseletivo.AttusProcessoSeletivoApplication;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = AttusProcessoSeletivoApplication.class)
public class EnderecoServiceTest {

    @Autowired
    private EnderecoService enderecoService;
    @Test
    public void deveCriarEnderecoParaPessoa() {}
    @Test
    public void deveEditarUmEndereco() {
        Mockito.when(enderecoService.update()).then(()-> Assertions.assertTrue(true));
    }
    @Test
    public void deveConsultarEnderecoPelaPessoa() {}
    @Test
    public void deveConsultarEnderecosDeMultiplasPessoas() {}
    @Test
    public void deveTornarEnderecoPrincipal() {}
    @Test
    public void naoDeveTerMaisDeUmEnderecoPrincipal() {}
    @Test
    public void naoDeveCriarEnderecoSemCep() {}
    @Test
    public void naoDeveCriarEnderecoSemLogradouro() {}
}
