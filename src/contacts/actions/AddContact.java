package contacts.actions;

import contacts.Database;

import java.util.Scanner;

public class AddContact implements Action {

    @Override
    public void execute(Scanner scanner, Database database) {
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the surname: ");
        String surname = scanner.nextLine();
        System.out.print("Enter the number: ");
        String number = scanner.nextLine();
        database.addContact(name, surname, number);
        System.out.println("The record added.");
    }
}
