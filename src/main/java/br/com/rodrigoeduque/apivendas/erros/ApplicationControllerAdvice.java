package br.com.rodrigoeduque.apivendas.erros;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroPadrao> ExceptionValidation(Exception exception, WebRequest request) {
        String message = exception.getMessage();
        exception.printStackTrace();

        return ResponseEntity.internalServerError().body(new ErroPadrao(LocalDateTime.now(), request.getLocale().toString(), message));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorApi>> ExceptionApiHandler(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        List<ErrorApi> errors = fieldErrors.stream().
                map(FieldError ->
                        new ErrorApi(FieldError.getField(), FieldError.getDefaultMessage()))
                .collect(Collectors.toList());
        return ResponseEntity.badRequest().body(errors);
    }
}