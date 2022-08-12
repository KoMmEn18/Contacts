package contacts.actions;

import contacts.Database;
import java.util.Scanner;

public interface Action {

    public void execute(Scanner scanner, Database database);

    public String getName();
}
