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
        Organization organization = new Organization();

        System.out.print("Enter the name: ");
        organization.setName(scanner.nextLine());

        System.out.print("Enter the address: ");
        organization.setAddress(scanner.nextLine());

        System.out.print("Enter the number: ");
        organization.setNumber(scanner.nextLine());

        return organization;
    }
}
