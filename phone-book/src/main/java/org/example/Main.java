package org.example;

public class Main {
    public static void main(String[] args) throws ContactAlreadyExistsException {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Petya", 12345678);
        phoneBook.add("Masha", 23456789);
        phoneBook.add("Anya", 34567890);
        phoneBook.printAllNames();
    }
}