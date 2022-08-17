package contacts.models;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

public abstract class Contact {
    private String number;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    protected Contact(String number) {
        setNumber(number);
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public String getNumber() {
        return hasNumber() ? number : "[no number]";
    }

    public void setNumber(String number) {
        if(isNumberValid(number)) {
            this.number = number;
        } else {
            System.out.println("Wrong number format");
            this.number = "";
        }
        setUpdatedAt();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    protected void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }

    public boolean hasNumber() {
        return !number.isEmpty();
    }

    private static boolean isNumberValid(String number) {
        Pattern pattern = Pattern.compile("^\\+?(\\(\\w+\\)|\\w+[ -]\\(\\w{2,}\\)|\\w+)([ -]\\w{2,})*$");
        return pattern.matcher(number).matches();
    }

    public abstract String toSimpleString();

    @Override
    public String toString() {
        return String.join(System.getProperty("line.separator"),
                "Number: " + getNumber(),
                "Time created: " + getCreatedAt(),
                "Time last edit: " + getUpdatedAt());
    }
}
