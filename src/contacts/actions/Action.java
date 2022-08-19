package contacts.actions;

import contacts.Database;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public interface Action {

    Map<String, Action> actions = getActions();

    public void execute(Scanner scanner, Database database);

    public default boolean isModifyingData() {
        return false;
    }

    private static Map<String, Action> getActions() {
        var map = new LinkedHashMap<String, Action>();
        map.put("add", new AddContact());
        map.put("remove", new RemoveContact());
        map.put("edit", new EditContact());
        map.put("count", new CountContacts());
        map.put("info", new ShowContactInfo());
        map.put("exit", new TerminateApp());

        return Collections.unmodifiableMap(map);
    }
}
