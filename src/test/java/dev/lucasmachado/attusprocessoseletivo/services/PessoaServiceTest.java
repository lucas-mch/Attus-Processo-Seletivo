package dev.lucasmachado.attusprocessoseletivo.services;

import dev.lucasmachado.attusprocessoseletivo.AttusProcessoSeletivoApplication;

import dev.lucasmachado.attusprocessoseletivo.factories.PessoaFactory;
import dev.lucasmachado.attusprocessoseletivo.model.Pessoa;
import dev.lucasmachado.attusprocessoseletivo.repositories.PessoaRepository;
import org.hibernate.ObjectNotFoundException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.*;

import static dev.lucasmachado.attusprocessoseletivo.factories.PessoaFactory.pessoaPadrao;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = AttusProcessoSeletivoApplication.class)
@ComponentScan("dev.lucasmachado.attusprocessoseletivo")
public class PessoaServiceTest {

    @Autowired
    private PessoaService pessoaService;

    @Mock
    private PessoaRepository pessoaRepository;

    @Test
    public void deveCriarUmaPessoa() {

        Pessoa pessoaParaSalvar = pessoaPadrao(null);

        Pessoa pessoaSalva = pessoaService.save(pessoaParaSalvar);

        Assertions.assertNotNull(pessoaSalva.getId(),"");
        Assertions.assertEquals(pessoaSalva.getNomeCompleto(),pessoaParaSalvar.getNomeCompleto());
        Assertions.assertNotNull(pessoaRepository.findById(pessoaSalva.getId()));
    }
    @Test
    public void deveCriarMultiplasPessoas() {
        List<Pessoa> pessoasParaSalvar = Arrays.asList(
                pessoaPadrao("Lucas"),
                pessoaPadrao("Marcia"),
                pessoaPadrao("Thomas"),
                pessoaPadrao("Joana")
        );
        List<Pessoa> pessoasSalvas = pessoaService.saveAll(pessoasParaSalvar);
        int idx = 0;

        Assertions.assertEquals(pessoasParaSalvar.size(), pessoasSalvas.size());

        for(Pessoa pessoaSalva : pessoasSalvas) {
            Assertions.assertEquals(pessoaSalva.getNomeCompleto(), pessoasParaSalvar.get(idx).getNomeCompleto());
            Assertions.assertEquals(pessoaSalva.getDataNascimento(), pessoasParaSalvar.get(idx).getDataNascimento());
            Assertions.assertNotNull(pessoaSalva.getId());
            idx++;
        }

    }
    @Test
    public void deveConsultarUmaPessoa() {
        Pessoa pessoaDesejada = pessoaPadrao(null);
        Pessoa pessoaPesquisada = pessoaService.find(1L);
        Assertions.assertNotNull(pessoaPesquisada.getId());
        Assertions.assertEquals(pessoaPesquisada.getNomeCompleto(),pessoaDesejada.getNomeCompleto());
    }
    @Test
    public void deveConsultarMultiplasPessoas() {
        List<Long> ids = Arrays.asList(1L,2L,3L);
        List<Pessoa> listaDePessoas = pessoaService.findAll(ids);
        Assertions.assertNotNull(listaDePessoas);
        Assertions.assertEquals(listaDePessoas.size(), ids.size());
    }
    @Test
    public void naoDeveCriarPessoaSemNome() {
        Pessoa pessoaSemNome = PessoaFactory.pessoaSemNome();

        MethodArgumentNotValidException ex = Assertions.assertThrows(MethodArgumentNotValidException.class,() -> pessoaService.save(pessoaSemNome));

        Assertions.assertNotNull(ex);
    }
    @Test
    public void naoDeveCriarPessoaSemDataNascimento() {
        Pessoa pessoaSemNome = PessoaFactory.pessoaSemDataNascimento();

        MethodArgumentNotValidException ex = Assertions.assertThrows(MethodArgumentNotValidException.class,() -> pessoaService.save(pessoaSemNome));

        Assertions.assertNotNull(ex);
    }
    @Test
    public void deveLancarExceptionAoConsultarPessoaNaoExistente() {

        ObjectNotFoundException ex = Assertions.assertThrows(ObjectNotFoundException.class,() -> pessoaService.find(999L));

        Assertions.assertNotNull(ex);
    }

    @Test
    public void deveAlterarUmaPessoa() {

    }
}
