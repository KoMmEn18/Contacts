package contacts;

import java.util.ArrayList;

public class Database {

    private ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(String name, String surname, String number) {
        contacts.add(new Contact.ContactBuilder()
                .setName(name)
                .setSurname(surname)
                .setNumber(number)
                .build());
    }

    public boolean removeContact(int index) {
        if (index < 0 || index >= contacts.size()) {
            return false;
        }
        contacts.remove(index);
        return true;
    }

    public boolean updateContactName(int index, String name) {
        if (isIndexInvalid(index)) {
            return false;
        }
        contacts.get(index).setName(name);
        return true;
    }

    public boolean updateContactSurname(int index, String surname) {
        if (isIndexInvalid(index)) {
            return false;
        }
        contacts.get(index).setSurname(surname);
        return true;
    }

    public boolean updateContactNumber(int index, String number) {
        if (isIndexInvalid(index)) {
            return false;
        }
        contacts.get(index).setNumber(number);
        return true;
    }

    public ArrayList<Contact> getContacts() {
        return (ArrayList<Contact>) contacts.clone();
    }

    public int getContactsCount() {
        return contacts.size();
    }

    public boolean hasContacts() {
        return contacts.size() > 0;
    }

    private boolean isIndexInvalid(int index) {
        return index < 0 || index >= contacts.size();
    }
}
