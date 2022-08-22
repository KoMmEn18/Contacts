package contacts.actions;

import contacts.Context;
import contacts.models.Contact;
import contacts.Database;

import java.util.ArrayList;
import java.util.Scanner;

public class ListContacts implements Action {

    @Override
    public void execute(Context context) {
        Database database = context.getDatabase();
        Scanner scanner = context.getScanner();

        if (database.hasContacts()) {
            printContacts(database.getContacts());
            boolean actionChosen = false;
            while (!actionChosen) {
                System.out.print("[list] Enter action ([number], back): ");
                String action = scanner.nextLine();
                switch (action) {
                    case "back" -> {}
                    default -> {
                        int record = -1;
                        try {
                            record = Integer.parseInt(action) - 1;
                        } catch (NumberFormatException ignore) {}

                        if (database.isIndexValid(record)) {
                            context.addNextAction(new PrintContactInfo());
                            context.addNextAction(new ManageContact());
                            context.setContactIndex(record);
                        } else {
                            System.out.println("That's not a valid action. Try again");
                            continue;
                        }
                    }
                }
                actionChosen = true;
            }
        } else {
            System.out.println("No records to list!");
        }
    }

    private void printContacts(ArrayList<Contact> contacts) {
        int counter = 1;
        for (Contact contact : contacts) {
            System.out.println(counter++ + ". " + contact.toSimpleString());
        }
        System.out.println();
    }
}
