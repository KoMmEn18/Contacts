package contacts.actions;

import contacts.Context;
import contacts.models.Contact;

public class PrintContactInfo implements Action {

    @Override
    public void execute(Context context) {
        Contact contact = context.getDatabase().getContact(context.getContactIndex());
        System.out.println(contact);
    }
}
