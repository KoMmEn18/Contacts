package contacts.actions;

import contacts.Database;

import java.util.Scanner;

public class UnknownAction implements Action {
    @Override
    public void execute(Scanner scanner, Database database) {
        System.out.println("Undefined action. Please try again");
    }
}
