package contacts.actions;

import contacts.Context;
import contacts.Database;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Scanner;

public class EditContact implements Action {
    @Override
    public void execute(Context context) {
        Database database = context.getDatabase();
        Scanner scanner = context.getScanner();

        boolean contactEdited = false;
        while (!contactEdited) {
            int index = context.getContactIndex();
            if (database.isIndexValid(index)) {
                List<String> fields = database.getContactEditableFields(index);
                String fieldsString = String.join(", ", fields);
                System.out.print("Select a field (" + fieldsString + "): ");
                String field = scanner.nextLine().toLowerCase();

                if (fields.contains(field)) {
                    System.out.print("Enter " + field + ": ");
                    String value = scanner.nextLine();
                    try {
                        contactEdited = database.editContact(index, field, value);
                    } catch (InvocationTargetException|IllegalAccessException ex) {
                        throw new RuntimeException(ex);
                    }
                }

                if (!contactEdited) {
                    System.out.println("You have not provided valid field. Try again");
                }
            }

        }
        System.out.println("Saved");
        context.addNextAction(new PrintContactInfo());
        context.addNextAction(new ManageContact());
    }

    @Override
    public boolean isModifyingData() {
        return true;
    }
}
