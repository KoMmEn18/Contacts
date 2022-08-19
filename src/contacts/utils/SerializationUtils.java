package contacts.utils;

import contacts.Database;
import contacts.models.Contact;

import java.io.*;
import java.util.ArrayList;

public class SerializationUtils {

    public static void serialize(String filename, Database database) {
        File file = new File(filename);
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            ArrayList<Contact> contacts = database.getContacts();
            for (Contact contact : contacts) {
                outputStream.writeObject(contact);
            }
            outputStream.writeObject(null);
        } catch (IOException ex) {
            System.out.printf("An exception occurred %s", ex.getMessage());
        }
    }

    public static void deserialize(String filename, Database database) {
        File file = new File(filename);
        if (file.exists()) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
                Contact contact;
                while ((contact = (Contact) inputStream.readObject()) != null) {
                    database.addContact(contact);
                }
            } catch (IOException|NumberFormatException|ClassNotFoundException ex) {
                System.out.printf("An exception occurred %s", ex.getMessage());
            }
        }
    }
}
