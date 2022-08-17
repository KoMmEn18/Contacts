package contacts;

import contacts.models.Contact;
import contacts.models.Organization;
import contacts.models.Person;

import java.time.LocalDate;
import java.util.ArrayList;

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

    public boolean updatePersonName(int index, String name) {
        if (!canUpdatePerson(index)) {
            return false;
        }
        Person contact = (Person) contacts.get(index);
        contact.setName(name);
        return true;
    }

    public boolean updatePersonSurname(int index, String surname) {
        if (!canUpdatePerson(index)) {
            return false;
        }
        Person contact = (Person) contacts.get(index);
        contact.setSurname(surname);
        return true;
    }

    public boolean updatePersonBirthDate(int index, LocalDate birthDate) {
        if (!canUpdatePerson(index)) {
            return false;
        }
        Person contact = (Person) contacts.get(index);
        contact.setBirthDate(birthDate);
        return true;
    }

    public boolean updatePersonGender(int index, Person.Gender gender) {
        if (!canUpdatePerson(index)) {
            return false;
        }
        Person contact = (Person) contacts.get(index);
        contact.setGender(gender);
        return true;
    }

    public boolean updateOrganizationAddress(int index, String address) {
        if (!canUpdateOrganization(index)) {
            return false;
        }
        Organization organization = (Organization) contacts.get(index);
        organization.setAddress(address);
        return true;
    }

    public boolean updateContactNumber(int index, String number) {
        if (!isIndexValid(index)) {
            return false;
        }
        contacts.get(index).setNumber(number);
        return true;
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

    public boolean isPersonInstance(int index) {
        return contacts.get(index) instanceof Person;
    }

    public boolean isOrganizationInstance(int index) {
        return contacts.get(index) instanceof Organization;
    }

    private boolean canUpdatePerson(int index) {
        return isIndexValid(index) && isPersonInstance(index);
    }

    private boolean canUpdateOrganization(int index) {
        return isIndexValid(index) && isOrganizationInstance(index);
    }
}
