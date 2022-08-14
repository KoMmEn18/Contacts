package contacts.actions;

import contacts.Database;

import java.util.Scanner;

public class CountContacts implements Action {

    @Override
    public void execute(Scanner scanner, Database database) {
        System.out.println("The Phone Book has " + database.getContactsCount() + " records.");
    }
}
