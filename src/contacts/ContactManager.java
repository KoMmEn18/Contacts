package contacts;

import contacts.actions.Action;
import contacts.actions.ActionManager;
import contacts.utils.SerializationUtils;

import java.util.Scanner;

public class ContactManager {

    private final ActionManager actionManager = new ActionManager();
    private final Scanner scanner = new Scanner(System.in);
    private final Database database = new Database();

    private String filename = "";

    public ContactManager() {}

    public ContactManager(String filename) {
        this.filename = filename;
    }

    public void run() {
        deserializeContacts();
        while (true) {
            printActionMenu();
            String action = scanner.nextLine();
            actionManager.setAction(action);
            actionManager.execute(scanner, database);
            serializeContacts();
            System.out.println();
        }
    }

    private void printActionMenu() {
        System.out.print("Enter action (");
        System.out.print(String.join(", ", Action.actions.keySet()));
        System.out.print("): ");
    }

    private void deserializeContacts() {
        if (isFilenameSpecified()) {
            SerializationUtils.deserialize(filename, database);
        }
    }

    private void serializeContacts() {
        if (actionManager.getAction().isModifyingData() && isFilenameSpecified()) {
            SerializationUtils.serialize(filename, database);
        }
    }

    private boolean isFilenameSpecified() {
        return filename.length() > 0;
    }
}
