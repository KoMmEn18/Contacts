package contacts.actions;

import contacts.Context;

import java.util.Scanner;

public class ManageContact implements Action {
    @Override
    public void execute(Context context) {
        Scanner scanner = context.getScanner();
        boolean actionChosen = false;
        while (!actionChosen) {
            System.out.print("[record] Enter action (edit, delete, menu): ");
            String action = scanner.nextLine();
            actionChosen = switch (action) {
                case "edit" -> {
                    context.addNextAction(new EditContact());
                    yield true;
                }
                case "delete" -> {
                    context.addNextAction(new DeleteContact());
                    yield true;
                }
                case "menu" -> true;
                default -> {
                    System.out.println("That's not a valid action. Try again");
                    yield false;
                }
            };
        }
    }
}
