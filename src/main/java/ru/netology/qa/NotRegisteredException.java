package ru.netology.qa;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String message) {
      super(message);
    }
}
