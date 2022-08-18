package contacts.models.factories;

import contacts.models.Contact;
import contacts.models.Person;

import java.util.Scanner;

public class PersonFactory implements ContactFactory {

    private Scanner scanner;

    public PersonFactory(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Contact create() {
        Person person = new Person();

        System.out.print("Enter the name: ");
        person.setName(scanner.nextLine());

        System.out.print("Enter the surname: ");
        person.setSurname(scanner.nextLine());

        System.out.print("Enter the birth date: ");
        person.setBirth(scanner.nextLine());

        System.out.print("Enter the gender (M, F): ");
        person.setGender(scanner.nextLine());

        System.out.print("Enter the number: ");
        person.setNumber(scanner.nextLine());

        return person;
    }
}
