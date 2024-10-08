package org.example;

public class ContactAlreadyExistsException extends Exception{
    public ContactAlreadyExistsException(String message) {
        super(message);
    }
}
