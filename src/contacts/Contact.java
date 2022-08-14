package contacts;

import java.util.regex.Pattern;

public class Contact {
    private String name;
    private String surname;
    private String number;

    private Contact(String name, String surname, String number) {
        setName(name);
        setSurname(surname);
        setNumber(number);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumber() {
        return hasNumber() ? number : "[no number]";
    }

    public void setNumber(String number) {
        if(isNumberValid(number)) {
            this.number = number;
        } else {
            System.out.println("Wrong number format");
            this.number = "";
        }
    }

    public boolean hasNumber() {
        return !number.isEmpty();
    }

    @Override
    public String toString() {
        return getName() + " " + getSurname() + ", " + getNumber();
    }

    private static boolean isNumberValid(String number) {
        Pattern pattern = Pattern.compile("^\\+?(\\(\\w+\\)|\\w+[ -]\\(\\w{2,}\\)|\\w+)([ -]\\w{2,})*$");
        return pattern.matcher(number).matches();
    }

    public static class ContactBuilder {

        private String name = "";
        private String surname = "";
        private String number = "";

        public ContactBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ContactBuilder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public ContactBuilder setNumber(String number) {
            this.number = number;
            return this;
        }

        public Contact build() {
            return new Contact(name, surname, number);
        }
    }
}
