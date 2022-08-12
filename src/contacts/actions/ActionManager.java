package contacts.actions;

import contacts.Database;
import java.util.Scanner;

public class ActionManager {
    private Action action;

    public void setAction(Action action) {
        this.action = action;
    }

    public void execute(Scanner scanner, Database database) {
        this.action.execute(scanner, database);
    }
}
