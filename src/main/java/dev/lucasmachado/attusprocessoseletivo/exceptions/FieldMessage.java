package dev.lucasmachado.attusprocessoseletivo.exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable {

    private String fieldName;

    private String msgError;

    public FieldMessage() {
    }

    public FieldMessage(String fieldName, String msgError) {
        this.fieldName = fieldName;
        this.msgError = msgError;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMsgError() {
        return msgError;
    }

    public void setMsgError(String msgError) {
        this.msgError = msgError;
    }
}
