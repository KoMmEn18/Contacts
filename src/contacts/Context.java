package contacts;

import contacts.actions.Action;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Context {
    private final Scanner scanner = new Scanner(System.in);
    private final Database database = new Database();
    private final ArrayDeque<Action> nextActions = new ArrayDeque<>();

    private int contactIndex = 0;
    private static final Context context = new Context();

    private Context() {}

    public Scanner getScanner() {
        return scanner;
    }

    public Database getDatabase() {
        return database;
    }

    public Action getNextAction() {
        return nextActions.pollLast();
    }

    public void addNextAction(Action action) {
        nextActions.push(action);
    }

    public int getContactIndex() {
        return contactIndex;
    }

    public void setContactIndex(int contactIndex) {
        this.contactIndex = contactIndex;
    }

    public static Context getContext() {
        return context;
    }
}
