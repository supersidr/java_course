public class PersonBuilder {
    public String name;
    public String surname;
    public int age;
    public String city;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }
    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age не может быть отрицательным");
        }
        this.age = age;
        return this;
    }
    public PersonBuilder setAddress(String address) {
        this.city = address;
        return this;
    }


    public Person build() {
        if (this.name == null) {
            throw new IllegalStateException("Заполните поле name");
        }
        if (this.surname == null) {
            throw new IllegalArgumentException("Заполните поле surname");
        }
        Person person = new Person(this.name, this.surname, this.age);
        person.setAddress(this.city);
        return person;
    }
}