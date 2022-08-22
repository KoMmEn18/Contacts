package contacts;

public class Main {
    public static void main(String[] args) {
        ContactManager contactManager =  new ContactManager(args.length == 1 ? args[0] : "");
        contactManager.run();
    }
}
