package org.example;

import java.util.HashMap;

public class PhoneBook {
    protected HashMap<String, Integer> contacts;

    public PhoneBook() {
        this.contacts = new HashMap<>();
    }

    public int add(String name, Integer phoneNumber) throws ContactAlreadyExistsException {
        if (this.contacts.containsKey(name.toUpperCase())) {
            throw new ContactAlreadyExistsException("Контакт с имененм " + name + " уже существует.");
        }
        contacts.put(name.toUpperCase(), phoneNumber);
        return contacts.size();
    }
}
