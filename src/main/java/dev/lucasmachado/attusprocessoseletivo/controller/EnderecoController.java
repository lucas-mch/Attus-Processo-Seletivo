package dev.lucasmachado.attusprocessoseletivo.controller;

import dev.lucasmachado.attusprocessoseletivo.model.Pessoa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoas")
public class EnderecoController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> find() {
        Pessoa pessoa = Pessoa.Builder.create()
                .id(1L)
                .nomeCompleto("Lucas Machado")
                .build();
        return ResponseEntity.ok().body(pessoa);
    }
}
