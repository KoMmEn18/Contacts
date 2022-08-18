package contacts;

import contacts.models.Contact;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public boolean removeContact(int index) {
        if (!isIndexValid(index)) {
            return false;
        }
        contacts.remove(index);
        return true;
    }

    public boolean updateField(int index, String field, String value) throws InvocationTargetException, IllegalAccessException {
        if (!isIndexValid(index)) {
            return false;
        }

        contacts.get(index).setField(field, value);
        return true;
    }

    public List<String> getContactEditableFields(int index) {
        if (!isIndexValid(index)) {
            return null;
        }

        return contacts.get(index).getEditableFields();
    }

    public Contact getContact(int index) {
        if (!isIndexValid(index)) {
            return null;
        }
        return contacts.get(index);
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

    public boolean isIndexValid(int index) {
        return index >= 0 && index < contacts.size();
    }
}
