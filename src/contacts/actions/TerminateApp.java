package contacts.actions;

import contacts.Database;

import java.util.Scanner;

public class TerminateApp implements Action {
    @Override
    public void execute(Scanner scanner, Database database) {
        System.exit(1);
    }
}
