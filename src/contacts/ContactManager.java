package contacts;

import contacts.actions.ActionManager;
import contacts.actions.AddContact;
import java.util.Scanner;

public class ContactManager {

    private final ActionManager actionManager = new ActionManager();
    private final Scanner scanner = new Scanner(System.in);
    private final Database database = new Database();

    public void run() {
        actionManager.setAction(new AddContact());
        actionManager.execute(scanner, database);
    }
}
