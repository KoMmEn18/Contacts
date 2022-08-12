package contacts;

import java.util.ArrayList;

public class Database {

    private ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(String name, String surname, String number) {
        contacts.add(new Contact(name, surname, number));
    }
}
