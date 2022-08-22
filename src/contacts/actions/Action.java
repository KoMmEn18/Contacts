package contacts.actions;

import contacts.Context;


import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public interface Action {

    Map<String, Action> actions = getActions();

    public void execute(Context context);

    public default boolean isModifyingData() {
        return false;
    }

    private static Map<String, Action> getActions() {
        var map = new LinkedHashMap<String, Action>();
        map.put("add", new AddContact());
        map.put("list", new ListContacts());
        map.put("search", new SearchContacts());
        map.put("count", new CountContacts());
        map.put("exit", new TerminateApp());

        return Collections.unmodifiableMap(map);
    }
}
