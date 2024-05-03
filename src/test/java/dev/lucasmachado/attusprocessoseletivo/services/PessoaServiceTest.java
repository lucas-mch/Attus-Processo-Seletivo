package dev.lucasmachado.attusprocessoseletivo.services;

import dev.lucasmachado.attusprocessoseletivo.AttusProcessoSeletivoApplication;

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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.*;

import static dev.lucasmachado.attusprocessoseletivo.factories.PessoaFactory.newPessoa;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = AttusProcessoSeletivoApplication.class)
public class PessoaServiceTest {

    @Autowired
    private PessoaService pessoaService;

    @Mock
    private PessoaRepository pessoaRepository;

    @Test
    public void deveCriarUmaPessoa() {

        Pessoa pessoaParaSalvar = newPessoa(null,9,11,1936);

        Pessoa pessoaSalva = pessoaService.save(pessoaParaSalvar);

        Assertions.assertNotNull(pessoaSalva.getId(),"");
        Assertions.assertEquals(pessoaSalva.getNomeCompleto(),pessoaParaSalvar.getNomeCompleto());
        Assertions.assertNotNull(pessoaRepository.findById(pessoaSalva.getId()));
    }
    @Test
    public void deveCriarMultiplasPessoas() {
        List<Pessoa> pessoasParaSalvar = Arrays.asList(
                newPessoa("Lucas",11,1,1945),
                newPessoa("Marcia",15,4,1925),
                newPessoa("Thomas",5,4,1974),
                newPessoa("Joana",2,7,1978)
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
        Pessoa pessoaDesejada = newPessoa(null,null,null,null);
        Pessoa pessoaPesquisada = pessoaService.find(1L);
        Assertions.assertNotNull(pessoaPesquisada.getId());
        Assertions.assertEquals(pessoaPesquisada.getNomeCompleto(),pessoaDesejada.getNomeCompleto());
    }
    @Test
    public void deveConsultarMultiplasPessoas() {
        List<Long> ids = Arrays.asList(1L,2L,3L);
        List<Pessoa> listaDePessoas = pessoaService.findList(ids);
        Assertions.assertNotNull(listaDePessoas);
        Assertions.assertEquals(listaDePessoas.size(), ids.size());
    }
    @Test
    public void naoDeveCriarPessoaSemNome() {
        Pessoa pessoaSemNome = newPessoa("Lucas",11,10,1998);
        pessoaSemNome.setNomeCompleto(null);

        MethodArgumentNotValidException ex = Assertions.assertThrows(MethodArgumentNotValidException.class,() -> pessoaService.save(pessoaSemNome));

        Assertions.assertNotNull(ex);
    }
    @Test
    public void naoDeveCriarPessoaSemDataNascimento() {
        Pessoa pessoaSemNome = newPessoa("Lucas",11,10,1998);
        pessoaSemNome.setDataNascimento(null);

        MethodArgumentNotValidException ex = Assertions.assertThrows(MethodArgumentNotValidException.class,() -> pessoaService.save(pessoaSemNome));

        Assertions.assertNotNull(ex);
    }
    @Test
    public void deveLancarExceptionAoConsultarPessoaNaoExistente() {

        ObjectNotFoundException ex = Assertions.assertThrows(ObjectNotFoundException.class,() -> pessoaService.find(999L));

        Assertions.assertNotNull(ex);
    }

}
