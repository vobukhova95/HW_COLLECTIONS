package ru.netology.qa.exception;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String message) {
        super(message);
    }
}
