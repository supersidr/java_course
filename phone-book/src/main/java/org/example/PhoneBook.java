package org.example;

import java.util.*;
import java.util.stream.Collectors;

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

    public String findByNumber(Integer phoneNumber) {
        for (String name : contacts.keySet()) {
            if (contacts.get(name).equals(phoneNumber)) {
                return name;
            }
        }
        return null;
    }

    public Integer findByName(String name) {
        return contacts.getOrDefault(name, null);
    }

    public void printAllNames() {
        List<String> namesList = new ArrayList<>(contacts.keySet());

        // Сортируем список имен
        Collections.sort(namesList);

        // Печатаем отсортированные имена
        for (String name : namesList) {
            System.out.println(name);
        }
    }
}
