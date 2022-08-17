package contacts.models;

import java.time.LocalDate;

public class Person extends Contact {

    public enum Gender {
        MALE, FEMALE
    }
    private String name;
    private String surname;

    private LocalDate birthDate;
    private Gender gender;

    private Person(String number, String name, String surname, LocalDate birthDate, Gender gender) {
        super(number);
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        setUpdatedAt();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
        setUpdatedAt();
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        setUpdatedAt();
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
        setUpdatedAt();
    }

    @Override
    public String toString() {
        return String.join(System.getProperty("line.separator"),
                "Name: " + getName(),
                "Surname: " + getSurname(),
                "Birth date: " + (getBirthDate() != null ? getBirthDate() : "[no data]"),
                "Gender: " + (getGender() != null ? getGender() : "[no data]"),
                super.toString());
    }

    @Override
    public String toSimpleString() {
        return getName() + " " + getSurname();
    }

    public static class PersonBuilder {

        private String number = "";
        private String name = "";
        private String surname = "";

        private LocalDate birthDate = null;
        private Gender gender = null;

        public PersonBuilder setNumber(String number) {
            this.number = number;
            return this;
        }

        public PersonBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public PersonBuilder setBirthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public PersonBuilder setGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Person build() {
            return new Person(number, name, surname, birthDate, gender);
        }
    }
}
