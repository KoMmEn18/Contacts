package contacts.actions;

import contacts.Database;
import contacts.models.editors.ContactEditor;
import contacts.models.editors.OrganizationEditor;
import contacts.models.editors.PersonEditor;

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

                ContactEditor contactEditor;
                if (database.isPersonInstance(record)) {
                    contactEditor = new PersonEditor(scanner, database);
                } else {
                    contactEditor = new OrganizationEditor(scanner, database);
                }

                contactEdited = contactEditor.edit(record);
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
