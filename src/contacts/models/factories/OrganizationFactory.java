package contacts.models.factories;

import contacts.models.Contact;
import contacts.models.Organization;

import java.util.Scanner;

public class OrganizationFactory implements ContactFactory {

    private Scanner scanner;

    public OrganizationFactory(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Contact create() {
        Organization.OrganizationBuilder organizationBuilder = new Organization.OrganizationBuilder();

        System.out.print("Enter the name: ");
        organizationBuilder.setName(scanner.nextLine());

        System.out.print("Enter the address: ");
        organizationBuilder.setAddress(scanner.nextLine());

        System.out.print("Enter the number: ");
        organizationBuilder.setNumber(scanner.nextLine());

        return organizationBuilder.build();
    }
}
