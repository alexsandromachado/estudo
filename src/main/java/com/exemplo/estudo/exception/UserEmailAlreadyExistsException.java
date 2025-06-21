package com.exemplo.estudo.exception;

public class UserEmailAlreadyExistsException extends RuntimeException {
    public UserEmailAlreadyExistsException(String mensagem) {
        super (mensagem);
    }

}