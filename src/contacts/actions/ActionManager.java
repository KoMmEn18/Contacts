package contacts.actions;

import contacts.Context;

public class ActionManager {
    private Action action;

    public void setAction(String action) {
        this.action = Action.actions.getOrDefault(action, new UnknownAction());
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Action getAction() {
        return action;
    }

    public void execute(Context context) {
        this.action.execute(context);
    }
}
