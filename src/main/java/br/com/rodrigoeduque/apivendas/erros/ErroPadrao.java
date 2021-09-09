package br.com.rodrigoeduque.apivendas.erros;

import java.time.LocalDateTime;

public class ErroPadrao {

    private LocalDateTime localDateTime;
    private String statusCode;
    private String message;


    public ErroPadrao(LocalDateTime localDateTime, String statusCode, String message) {
        this.localDateTime = localDateTime;
        this.statusCode = statusCode;
        this.message = message;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}
