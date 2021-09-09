package br.com.rodrigoeduque.apivendas.erros;

public class ErrorApi {
    private String field;
    private String message;

    public ErrorApi(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
