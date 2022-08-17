package contacts.models;

public class Organization extends Contact {

    private String name;
    private String address;

    private Organization(String number, String name, String address) {
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

    public static class OrganizationBuilder {

        private String number = "";
        private String name = "";
        private String address = "";

        public OrganizationBuilder setNumber(String number) {
            this.number = number;
            return this;
        }

        public OrganizationBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public OrganizationBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Organization build() {
            return new Organization(number, name, address);
        }
    }
}
