package contacts.actions;

import contacts.Context;
import contacts.Database;

public class DeleteContact implements Action {
    @Override
    public void execute(Context context) {
        Database database = context.getDatabase();

        boolean contactRemoved = database.removeContact(context.getContactIndex());
        if (contactRemoved) {
            System.out.println("The record removed!");
        } else {
            System.out.println("Record was not removed!");
        }
    }

    @Override
    public boolean isModifyingData() {
        return true;
    }
}
