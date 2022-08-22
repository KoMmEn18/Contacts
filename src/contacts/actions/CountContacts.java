package contacts.actions;

import contacts.Context;

public class CountContacts implements Action {

    @Override
    public void execute(Context context) {
        System.out.println("The Phone Book has " + context.getDatabase().getContactsCount() + " records.");
    }
}
