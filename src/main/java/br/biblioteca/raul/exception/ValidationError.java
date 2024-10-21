package br.biblioteca.raul.exception;

import lombok.Getter;

@Getter
public class ValidationError {
    private final String field;
    private final String message;

    ValidationError(String field, String message) {
        this.field = field;
        this.message = message;
    }
}
