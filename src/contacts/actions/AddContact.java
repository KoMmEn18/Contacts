package contacts.actions;

import contacts.Context;
import contacts.Database;
import contacts.models.factories.ContactFactory;
import contacts.models.factories.OrganizationFactory;
import contacts.models.factories.PersonFactory;

import java.util.Scanner;

public class AddContact implements Action {

    @Override
    public void execute(Context context) {
        Database database = context.getDatabase();
        Scanner scanner = context.getScanner();

        System.out.print("Enter the type (person, organization): ");
        boolean contactAdded = false;
        while (!contactAdded) {
            ContactFactory contactFactory = switch (scanner.nextLine().toLowerCase()) {
                case "person" -> new PersonFactory(scanner);
                case "organization" -> new OrganizationFactory(scanner);
                default -> null;
            };

            if (contactFactory == null) {
                System.out.println("You have not provided valid record number or field. Try again");
            } else {
                database.addContact(contactFactory.create());
                contactAdded = true;
            }
        }

        System.out.println("The record added.");
    }

    @Override
    public boolean isModifyingData() {
        return true;
    }
}
