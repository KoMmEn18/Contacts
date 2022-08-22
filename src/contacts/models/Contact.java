package contacts.models;

import java.io.Serial;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public abstract class Contact implements Serializable {
    private String number = "";
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Serial
    private static final long serialVersionUID = 1L;

    protected Contact() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    protected Contact(String number) {
        this();
        setNumber(number);
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

    public void setField(String field, String value) throws InvocationTargetException, IllegalAccessException {
        List<String> fields = getEditableFields();
        Method method = getMethod(this, field, "set");
        if (fields.contains(field) && method != null) {
            method.invoke(this, value);
            return;
        }

        throw new IllegalArgumentException();
    }

    public Object getField(String field) throws InvocationTargetException, IllegalAccessException {
        List<String> fields = getEditableFields();
        Method method = getMethod(this, field, "get");
        if (fields.contains(field) && method != null) {
            return method.invoke(this);
        }

        throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return String.join(System.getProperty("line.separator"),
                "Number: " + getNumber(),
                "Time created: " + getCreatedAt(),
                "Time last edit: " + getUpdatedAt());
    }

    public abstract String toSimpleString();

    public abstract List<String> getEditableFields();

    protected List<String> getAllEditableFields(Object obj) {
        ArrayList<Field> fields = new ArrayList<>();
        fields.addAll(List.of(obj.getClass().getDeclaredFields()));
        fields.addAll(List.of(obj.getClass().getSuperclass().getDeclaredFields()));
        ArrayList<String> nonEditableFields = new ArrayList<>(List.of(new String[]{"createdAt", "updatedAt", "serialVersionUID"}));
        fields.removeIf(field -> nonEditableFields.contains(field.getName()));

        return fields.stream().map(Field::getName).collect(Collectors.toList());
    }

    protected Method getMethod(Object obj, String input, String prefix) {
        return Arrays.stream(obj.getClass().getMethods())
                .filter(method -> method.getName().toLowerCase().equals(prefix + input))
                .findFirst()
                .orElse(null);
    }

    private static boolean isNumberValid(String number) {
        Pattern pattern = Pattern.compile("^\\+?(\\(\\w+\\)|\\w+[ -]\\(\\w{2,}\\)|\\w+)([ -]\\w{2,})*$");
        return pattern.matcher(number).matches();
    }
}
