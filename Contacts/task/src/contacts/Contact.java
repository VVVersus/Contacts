package contacts;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Contact implements Serializable {
    String number;
    boolean isPerson;
    LocalDateTime creationTime;
    LocalDateTime lastEditTime;

    public Contact(String number) {
        this.creationTime = LocalDateTime.now();
        this.lastEditTime = creationTime;
        setNumber(number);
    }

    public boolean isPerson() {
        return isPerson;
    }

    public void setPerson(boolean person) {
        isPerson = person;
    }

    public String getNumber() {
        if (number.isEmpty()) {
            return "[no data]";
        }
        return number;
    }

    public void setNumber(String number) {
        if (validateNumber(number)) {
            this.number = number;
        } else {
            this.number = "";
        }
    }

    public boolean hasNumber() {
        return !number.isEmpty();
    }

    private boolean validateNumber(String number) {
        Pattern pattern = Pattern.compile("^\\+?([\\da-z]+([\\s-]*\\(?[\\da-z]{2,}\\)?)?|\\(?[\\da-z]+\\)?([\\s-]*[\\da-z]{2,})?)([\\s-]*[\\da-z]{2,})*",
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(number);
        if (matcher.matches()) {
            this.number = number;
            return true;
        }
        return false;
    }
    public abstract String getContactString();

    public abstract String info();

    public abstract String getFields();

    public abstract boolean setField(String field, String value);
}
