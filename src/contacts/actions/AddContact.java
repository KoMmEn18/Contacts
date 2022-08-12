package contacts.actions;

import contacts.Database;

import java.util.Scanner;

public class AddContact implements Action {

    @Override
    public void execute(Scanner scanner, Database database) {
        System.out.println("Enter the name of the person:");
        String name = scanner.nextLine();
        System.out.println("Enter the surname of the person");
        String surname = scanner.nextLine();
        System.out.println("Enter the number:");
        String number = scanner.nextLine();
        database.addContact(name, surname, number);
        System.out.print("""
                
        A record created!
        A Phone Book with a single record created!
        """);
    }

    @Override
    public String getName() {
        return "add contact";
    }
}
