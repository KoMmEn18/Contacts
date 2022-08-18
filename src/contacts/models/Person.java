package contacts.models;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class Person extends Contact {

    public enum Gender {
        MALE, FEMALE
    }
    private String name = "";
    private String surname = "";

    private LocalDate birth = null;
    private Gender gender = null;

    public Person() {
        super();
    }

    public Person(String number, String name, String surname, LocalDate birth, Gender gender) {
        super(number);
        this.name = name;
        this.surname = surname;
        this.birth = birth;
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

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        try {
            this.birth = LocalDate.parse(birth);
        } catch (DateTimeParseException exception) {
            System.out.println("Bad birth date!");
        }
        setUpdatedAt();
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = switch (gender) {
            case "M" -> Gender.MALE;
            case "F" -> Gender.FEMALE;
            default -> {
                System.out.println("Bad gender");
                yield null;
            }
        };
        setUpdatedAt();
    }

    @Override
    public String toString() {
        return String.join(System.getProperty("line.separator"),
                "Name: " + getName(),
                "Surname: " + getSurname(),
                "Birth date: " + (getBirth() != null ? getBirth() : "[no data]"),
                "Gender: " + (getGender() != null ? getGender() : "[no data]"),
                super.toString());
    }

    @Override
    public String toSimpleString() {
        return getName() + " " + getSurname();
    }

    @Override
    public List<String> getEditableFields() {
        return getAllEditableFields(this);
    }
}
