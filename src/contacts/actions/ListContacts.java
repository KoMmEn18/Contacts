package contacts.actions;

import contacts.Contact;
import contacts.Database;

import java.util.ArrayList;
import java.util.Scanner;

public class ListContacts implements Action {

    @Override
    public void execute(Scanner scanner, Database database) {
        if (database.hasContacts()) {
            ArrayList<Contact> contacts = database.getContacts();
            int counter = 1;
            for (Contact contact : contacts) {
                System.out.println(counter++ + ". " + contact);
            }
        } else {
            System.out.println("No records to list!");
        }
    }
}
