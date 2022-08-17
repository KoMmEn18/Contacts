package contacts.models.editors;

import contacts.Database;

import java.util.Scanner;

public class OrganizationEditor extends ContactEditor {

    public OrganizationEditor(Scanner scanner, Database database) {
        super(scanner, database);
    }

    @Override
    public boolean edit(int record) {
        System.out.print("Select a field (address, number): ");
        String field = scanner.nextLine().toLowerCase();

        return switch (field) {
            case "address" -> updateAddress(record);
            case "number" -> updateNumber(record);
            default -> false;
        };
    }

    private boolean updateAddress(int record) {
        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        return database.updateOrganizationAddress(record, address);
    }
}
