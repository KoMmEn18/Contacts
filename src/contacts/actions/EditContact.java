package contacts.actions;

import contacts.Database;

import java.util.Scanner;

public class EditContact implements Action {

    private Database database;
    private Scanner scanner;

    @Override
    public void execute(Scanner scanner, Database database) {
        this.database = database;
        this.scanner = scanner;
        if (database.hasContacts()) {
            boolean edited = false;
            while (!edited) {
                (new ListContacts()).execute(scanner, database);
                System.out.print("Select a record: ");
                int record = -1;
                try {
                    record = Integer.parseInt(scanner.nextLine()) - 1;
                } catch (NumberFormatException ignore) {}
                System.out.print("Select a field (name, surname, number): ");
                String field = scanner.nextLine().toLowerCase();

                edited = switch (field) {
                    case "name" -> updateName(record);
                    case "surname" -> updateSurname(record);
                    case "number" -> updateNumber(record);
                    default -> false;
                };

                if (edited) {
                    System.out.println("The record updated!");
                } else {
                    System.out.println("You have not provided valid record number or field. Try again");
                }
            }
        } else {
            System.out.println("No records to edit!");
        }
    }

    private boolean updateName(int record) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        return database.updateContactName(record, name);
    }

    private boolean updateSurname(int record) {
        System.out.print("Enter surname: ");
        String surname = scanner.nextLine();

        return database.updateContactSurname(record, surname);
    }

    private boolean updateNumber(int record) {
        System.out.print("Enter number: ");
        String number = scanner.nextLine();

        return database.updateContactNumber(record, number);
    }
}
