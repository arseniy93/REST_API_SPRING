package com.rigin.conrtoller.handler;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.zalando.problem.Problem;
import org.zalando.problem.StatusType;

import java.net.URI;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Problem> handleResourceNotFoundException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(buildProblem(ex, request), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private Problem buildProblem(Exception exception, WebRequest request) {
        return Problem.builder()
                .withType(URI.create(request.getContextPath()))
                .withTitle(exception.getLocalizedMessage())
                .withStatus(new StatusType() {
                    @Override
                    public int getStatusCode() {
                        return 500;
                    }

                    @Override
                    public String getReasonPhrase() {
                        return "INTERNAL SERVER ERROR";
                    }
                })
                .withDetail(exception.getMessage())
                .build();
    }
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        String errorMessage = "Invalid input: " + ex.getName() + " should be of type " + ex.getRequiredType().getName();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler(org.springframework.web.HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<String> handleHttpRequestMethodNotSupportedException(org.springframework.web.HttpRequestMethodNotSupportedException ex) {
        String errorMessage = "Request method '" + ex.getMethod() + "' is not supported for this endpoint. Supported methods: " + String.join(", ", ex.getSupportedMethods());
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(errorMessage);
    }

}

