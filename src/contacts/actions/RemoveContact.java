package contacts.actions;

import contacts.Database;

import java.util.Scanner;

public class RemoveContact implements Action {
    @Override
    public void execute(Scanner scanner, Database database) {
        if (database.hasContacts()) {
            boolean contactRemoved = false;
            while (!contactRemoved) {
                (new ListContacts()).execute(scanner, database);
                System.out.print("Select a record: ");
                int record = -1;
                try {
                    record = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException ignore) {}

                contactRemoved = database.removeContact(record - 1);
                if (!contactRemoved) {
                    System.out.println("You have not provided valid record number. Try again");
                }
            }
            System.out.println("The record removed!");
        } else {
            System.out.println("No records to remove!");
        }
    }

    @Override
    public boolean isModifyingData() {
        return true;
    }
}
