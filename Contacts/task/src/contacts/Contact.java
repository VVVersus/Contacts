package contacts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {
    private String name;
    private String surname;
    private String number;

    public Contact(String name, String surname, String number) {
        this.name = name;
        this.surname = surname;
        setNumber(number);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if (validateNumber(number)) {
            this.number = number;
        } else {
            this.number = "";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    @Override
    public String toString() {
        return name + " " + surname + ", " + (hasNumber() ? number : "[no number]");
    }
}
