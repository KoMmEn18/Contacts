package contacts.models;

import java.util.List;

public class Organization extends Contact {

    private String name = "";
    private String address = "";

    public Organization() {
        super();
    }

    public Organization(String number, String name, String address) {
        super(number);
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        setUpdatedAt();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        setUpdatedAt();
    }

    @Override
    public String toString() {
        return String.join(System.getProperty("line.separator"),
                "Organization name: " + getName(),
                "Address: " + getAddress(),
                super.toString());
    }

    @Override
    public String toSimpleString() {
        return getName();
    }

    @Override
    public List<String> getEditableFields() {
        return getAllEditableFields(this);
    }
}
