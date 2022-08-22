package contacts.actions;

import contacts.Context;
import contacts.Database;
import contacts.models.Contact;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class SearchContacts implements Action {

    @Override
    public void execute(Context context) {
        Database database = context.getDatabase();
        Scanner scanner = context.getScanner();

        boolean searchingQuery = true;
        while (searchingQuery) {
            System.out.print("Enter search query: ");
            String searchQuery = scanner.nextLine();
            LinkedHashMap<Integer, Contact> results;
            try {
                results = database.searchContacts(searchQuery);
            } catch (InvocationTargetException|IllegalAccessException e) {
                throw new RuntimeException(e);
            }

            if (results.isEmpty()) {
                System.out.println("No results found");
                return;
            }

            printResults(results);
            boolean actionChosen = false;
            while (!actionChosen) {
                System.out.print("[search] Enter action ([number], back, again): ");
                String action = scanner.nextLine();
                switch (action) {
                    case "back" -> searchingQuery = false;
                    case "again" -> {}
                    default -> {
                        int record = -1;
                        try {
                            record = Integer.parseInt(action) - 1;
                        } catch (NumberFormatException ignore) {}

                        if (record >= 0 && record < results.size()) {
                            context.setContactIndex(new ArrayList<>(results.keySet()).get(record));
                            context.addNextAction(new PrintContactInfo());
                            context.addNextAction(new ManageContact());
                            searchingQuery = false;
                        } else {
                            System.out.println("That's not a valid action. Try again");
                            continue;
                        }
                    }
                }
                actionChosen = true;
            }
        }
    }

    private void printResults(LinkedHashMap<Integer, Contact> results) {
        System.out.println("Found " + results.size() + " results:");
        int counter = 1;
        for (Contact result : results.values()) {
            System.out.println(counter++ + ". " + result.toSimpleString());
        }
        System.out.println();
    }
}
