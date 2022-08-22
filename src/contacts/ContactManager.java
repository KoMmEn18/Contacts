package contacts;

import contacts.actions.Action;
import contacts.actions.ActionManager;
import contacts.utils.SerializationUtils;


public class ContactManager {

    private final ActionManager actionManager = new ActionManager();
    private final Context context = Context.getContext();
    private String filename;

    public ContactManager(String filename) {
        this.filename = filename;
    }

    public void run() {
        deserializeContacts();
        while (true) {
            Action nextAction = context.getNextAction();
            if (nextAction != null) {
                actionManager.setAction(nextAction);
            } else {
                printActionMenu();
                String action = context.getScanner().nextLine();
                actionManager.setAction(action);
            }
            actionManager.execute(context);
            System.out.println();
            serializeContacts();
        }
    }

    private void printActionMenu() {
        System.out.print("[menu] Enter action (");
        System.out.print(String.join(", ", Action.actions.keySet()));
        System.out.print("): ");
    }

    private void deserializeContacts() {
        Database database = context.getDatabase();
        if (isFilenameSpecified()) {
            SerializationUtils.deserialize(filename, database);
        }
    }

    private void serializeContacts() {
        Database database = context.getDatabase();
        if (actionManager.getAction().isModifyingData() && isFilenameSpecified()) {
            SerializationUtils.serialize(filename, database);
        }
    }

    private boolean isFilenameSpecified() {
        return filename.length() > 0;
    }
}
