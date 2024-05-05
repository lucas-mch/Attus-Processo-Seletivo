package dev.lucasmachado.attusprocessoseletivo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.lucasmachado.attusprocessoseletivo.model.Pessoa;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PessoaDTO implements DefaultDTO<Pessoa, PessoaDTO> {
    private Long id;
    @NotEmpty(message = "")
    @Length(min = 3, max = 250)
    private String nomeCompleto;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotEmpty(message = "")
    private Date dataNascimento;

    @Override
    public Pessoa toEntity() {
        return new Pessoa(this);
    }

    @Override
    public PessoaDTO convert(Pessoa pessoa) {
        BeanUtils.copyProperties(pessoa, this, "id", "nomeCompleto", "dataNascimento");
        return this;
    }

    @Override
    public List<PessoaDTO> convertToList(List<Pessoa> dto) {
        List<PessoaDTO> convertedList = new ArrayList<>();
        dto.forEach(entity -> {
            convertedList.add(this.convert(entity));
        });
        return convertedList;
    }

}
