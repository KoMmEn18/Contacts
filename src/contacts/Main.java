package contacts;

public class Main {
    public static void main(String[] args) {
        ContactManager contactManager = args.length == 1 ? new ContactManager(args[0]) : new ContactManager();
        contactManager.run();
    }
}
