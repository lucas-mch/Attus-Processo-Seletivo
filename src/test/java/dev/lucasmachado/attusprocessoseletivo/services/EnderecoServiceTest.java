package dev.lucasmachado.attusprocessoseletivo.services;

import dev.lucasmachado.attusprocessoseletivo.AttusProcessoSeletivoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = AttusProcessoSeletivoApplication.class)
public class EnderecoServiceTest {

    @Test
    public void deveCriarEnderecoParaPessoa() {}

    @Test
    public void deveEditarUmEndereco() {}

    @Test
    public void deveConsultarEnderecoPelaPessoa() {}

    @Test
    public void deveConsultarEnderecosDeMultiplasPessoas() {}


    @Test
    public void deveTornarEnderecoPrincipal() {}
}
