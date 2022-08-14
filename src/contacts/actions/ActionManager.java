package contacts.actions;

import contacts.Database;
import java.util.Scanner;

public class ActionManager {
    private Action action;

    public void setAction(String action) {
        this.action = Action.actions.getOrDefault(action, new UnknownAction());
    }

    public void execute(Scanner scanner, Database database) {
        this.action.execute(scanner, database);
    }
}
