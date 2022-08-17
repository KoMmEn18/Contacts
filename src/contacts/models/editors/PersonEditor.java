package contacts.models.editors;

import contacts.Database;
import contacts.models.Person;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class PersonEditor extends ContactEditor {

    public PersonEditor(Scanner scanner, Database database) {
        super(scanner, database);
    }

    @Override
    public boolean edit(int record) {
        System.out.print("Select a field (name, surname, birth, gender, number): ");
        String field = scanner.nextLine().toLowerCase();
        return switch (field) {
            case "name" -> updateName(record);
            case "surname" -> updateSurname(record);
            case "birth" -> updateBirth(record);
            case "gender" -> updateGender(record);
            case "number" -> updateNumber(record);
            default -> false;
        };
    }

    private boolean updateName(int record) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        return database.updatePersonName(record, name);
    }

    private boolean updateSurname(int record) {
        System.out.print("Enter surname: ");
        String surname = scanner.nextLine();

        return database.updatePersonSurname(record, surname);
    }

    private boolean updateBirth(int record) {
        System.out.print("Enter the birth date: ");
        LocalDate birthDate = null;
        try {
            birthDate = LocalDate.parse(scanner.nextLine());
        } catch (DateTimeParseException exception) {
            System.out.println("Bad birth date!");
        }

        return database.updatePersonBirthDate(record, birthDate);
    }

    private boolean updateGender(int record) {
        System.out.print("Enter the gender (M, F): ");
        Person.Gender gender = switch (scanner.nextLine().toUpperCase()) {
            case "M" -> Person.Gender.MALE;
            case "F" -> Person.Gender.FEMALE;
            default -> {
                System.out.println("Bad gender");
                yield null;
            }
        };

        return database.updatePersonGender(record, gender);
    }
}
