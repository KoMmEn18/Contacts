package contacts.actions;

import contacts.Database;

import java.util.Scanner;

public class RemoveContact implements Action {
    @Override
    public void execute(Scanner scanner, Database database) {
        if (database.hasContacts()) {
            boolean removed = false;
            while (!removed) {
                (new ListContacts()).execute(scanner, database);
                System.out.print("Select a record: ");
                int record = -1;
                try {
                    record = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException ignore) {}

                removed = database.removeContact(record - 1);
                if (removed) {
                    System.out.println("The record removed!");
                } else {
                    System.out.println("You have not provided valid record number. Try again");
                }
            }
        } else {
            System.out.println("No records to remove!");
        }
    }
}
