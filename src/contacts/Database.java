package contacts;

import contacts.models.Contact;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Pattern;

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

    public boolean editContact(int index, String field, String value) throws InvocationTargetException, IllegalAccessException {
        if (!isIndexValid(index)) {
            return false;
        }

        contacts.get(index).setField(field, value);
        return true;
    }

    public LinkedHashMap<Integer, Contact> searchContacts(String searchQuery) throws InvocationTargetException, IllegalAccessException {
        LinkedHashMap<Integer, Contact> results = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile(searchQuery, Pattern.CASE_INSENSITIVE);
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            var fields = contact.getEditableFields();
            for (String field : fields) {
                Object fieldObject = contact.getField(field);
                if (fieldObject != null) {
                    String fieldString = fieldObject.toString();
                    if (pattern.matcher(fieldString).find()) {
                        results.put(i, contact);
                        break;
                    }
                }
            }
        }

        return results;
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
