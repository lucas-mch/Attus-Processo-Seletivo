package dev.lucasmachado.attusprocessoseletivo.services;

import dev.lucasmachado.attusprocessoseletivo.AttusProcessoSeletivoApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = AttusProcessoSeletivoApplication.class)
public class PessoaServiceTest {

    @Autowired
    @Mock
    private PessoaService pessoaService;

    @Test
    public void deveCriarUmaPessoa() {}
    @Test
    public void deveCriarMultiplasPessoas() {}
    @Test
    public void deveConsultarUmaPessoa() {}
    @Test
    public void deveConsultarMultiplasPessoas() {}

}
