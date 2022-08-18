package contacts.actions;

import contacts.Database;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Scanner;

public class EditContact implements Action {
    @Override
    public void execute(Scanner scanner, Database database) {
        if (database.hasContacts()) {
            boolean contactEdited = false;
            while (!contactEdited) {
                (new ListContacts()).execute(scanner, database);
                System.out.print("Select a record: ");
                int record = -1;
                try {
                    record = Integer.parseInt(scanner.nextLine()) - 1;
                } catch (NumberFormatException ignore) {}

                if (!database.isIndexValid(record)) {
                    System.out.println("That's not a valid record number. Try again");
                    continue;
                }

                List<String> fields = database.getContactEditableFields(record);
                String fieldsString = String.join(", ", fields);
                System.out.print("Select a field (" + fieldsString + "): ");
                String field = scanner.nextLine().toLowerCase();

                if (fields.contains(field)) {
                    System.out.print("Enter " + field + ": ");
                    String value = scanner.nextLine();
                    try {
                        contactEdited = database.updateField(record, field, value);
                    } catch (InvocationTargetException|IllegalAccessException ex) {
                        throw new RuntimeException(ex);
                    }
                }

                if (!contactEdited) {
                    System.out.println("You have not provided valid field. Try again");
                }
            }
            System.out.println("The record updated!");
        } else {
            System.out.println("No records to edit!");
        }
    }
}
