package contacts;

import contacts.actions.Action;
import contacts.actions.ActionManager;
import java.util.Scanner;

public class ContactManager {

    private final ActionManager actionManager = new ActionManager();
    private final Scanner scanner = new Scanner(System.in);
    private final Database database = new Database();

    public void run() {
        while (true) {
            printActionMenu();
            String action = scanner.nextLine();
            actionManager.setAction(action);
            actionManager.execute(scanner, database);
            System.out.println();
        }
    }

    private void printActionMenu() {
        System.out.print("Enter action (");
        System.out.print(String.join(", ", Action.actions.keySet()));
        System.out.print("): ");
    }
}
