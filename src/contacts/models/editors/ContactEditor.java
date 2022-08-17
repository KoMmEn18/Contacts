package contacts.models.editors;

import contacts.Database;
import contacts.models.Contact;
import java.util.Scanner;

public abstract class ContactEditor {

    protected Scanner scanner;
    protected Database database;

    protected ContactEditor(Scanner scanner, Database database) {
        this.scanner = scanner;
        this.database = database;
    }
    public abstract boolean edit(int record);

    protected boolean updateNumber(int record) {
        System.out.print("Enter number: ");
        String number = scanner.nextLine();

        return database.updateContactNumber(record, number);
    }
}
