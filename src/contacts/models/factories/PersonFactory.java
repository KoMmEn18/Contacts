package contacts.models.factories;

import contacts.models.Contact;
import contacts.models.Person;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class PersonFactory implements ContactFactory {

    private Scanner scanner;

    public PersonFactory(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Contact create() {
        Person.PersonBuilder personBuilder = new Person.PersonBuilder();

        System.out.print("Enter the name: ");
        personBuilder.setName(scanner.nextLine());

        System.out.print("Enter the surname: ");
        personBuilder.setSurname(scanner.nextLine());

        System.out.print("Enter the birth date: ");
        LocalDate birthDate = null;
        try {
            birthDate = LocalDate.parse(scanner.nextLine());
        } catch (DateTimeParseException exception) {
            System.out.println("Bad birth date!");
        } finally {
            personBuilder.setBirthDate(birthDate);
        }

        System.out.print("Enter the gender (M, F): ");
        Person.Gender gender = switch (scanner.nextLine().toUpperCase()) {
            case "M" -> Person.Gender.MALE;
            case "F" -> Person.Gender.FEMALE;
            default -> {
                System.out.println("Bad gender");
                yield null;
            }
        };
        personBuilder.setGender(gender);

        System.out.print("Enter the number: ");
        personBuilder.setNumber(scanner.nextLine());

        return personBuilder.build();
    }
}
