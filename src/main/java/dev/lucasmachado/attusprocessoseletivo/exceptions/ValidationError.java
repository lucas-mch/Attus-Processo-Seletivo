package dev.lucasmachado.attusprocessoseletivo.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    private List<FieldMessage> errors = new ArrayList<>();
    public ValidationError(Integer status, String msg, Long timeStamp) {
        super(status, msg, timeStamp);
    }

    public ValidationError(Integer status, String msg, Long timeStamp, List<FieldMessage> list) {
        super(status, msg, timeStamp);
        this.errors = list;
    }


    public List<FieldMessage> getList() {
        return errors;
    }

    public void addError(FieldMessage message) {
        errors.add(message);
    }
}

