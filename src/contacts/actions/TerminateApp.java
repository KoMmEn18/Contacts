package contacts.actions;

import contacts.Context;

public class TerminateApp implements Action {
    @Override
    public void execute(Context context) {
        System.exit(1);
    }
}
