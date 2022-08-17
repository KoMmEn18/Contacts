package contacts.actions;

import contacts.Database;
import contacts.models.Contact;

import java.util.Scanner;

public class ShowContactInfo implements Action {

    @Override
    public void execute(Scanner scanner, Database database) {
        if (database.hasContacts()) {
            boolean infoShowed = false;
            while (!infoShowed) {
                (new ListContacts()).execute(scanner, database);
                System.out.print("Enter index to show info: ");
                int record = -1;
                try {
                    record = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException ignore) {}

                Contact contact = database.getContact(record - 1);
                if (contact == null) {
                    System.out.println("You have not provided valid record number. Try again");
                } else {
                    System.out.println(contact);
                    infoShowed = true;
                }
            }
        } else {
            System.out.println("No records to show!");
        }
    }
}
