package contacts;


import java.time.LocalDate;
import java.util.Locale;

enum Gender {
    M, F;
}

class PersonContact extends Contact {
    private String name;
    private String surname;
    private LocalDate birthDate;
    private Gender gender;

    public PersonContact(String name, String surname, LocalDate birthDate, Gender gender, String number) {
        super(number);
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
        this.setPerson(true);
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        if (birthDate == null) {
            System.out.println("Bad birth date!");
        } else {
            this.birthDate = birthDate;
        }
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        if (gender == null) {
            System.out.println("Bad gender!");
        } else {
            this.gender = gender;
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

    @Override
    public String toString() {
        return name + " " + surname;
    }

    @Override
    public String info() {
        return String.format("Name: %s\n" +
                        "Surname: %s\n" +
                        "Birth date: %s\n" +
                        "Gender: %s\n" +
                        "Number: %s\n" +
                        "Time created: %s\n" +
                        "Time last edit: %s", name, surname
                , (getBirthDate() == null ? "[no data]" : getBirthDate()), getGender() == null ? "[no data]" : getGender()
                , getNumber(), creationTime.withSecond(0).withNano(0), lastEditTime.withSecond(0).withNano(0));
    }

    @Override
    public String getFields() {
        return "(name, surname, birth, gender, number)";
    }

    @Override
    public String getContactString() {
        return (this.name + " " + this.surname + " " + this.number).toUpperCase(Locale.US);
    }

    @Override
    public boolean setField(String field, String value) {
        switch (field) {
            case "name":
                this.setName(value);
                return true;
            case "surname":
                this.setSurname(value);
                return true;
            case "birth":
                setBirthDate(LocalDate.parse(value));
                return true;
            case "gender":
                this.setGender(Gender.valueOf(value));
                return true;
            case "number":
                this.setNumber(value);
                return true;
            default:
                return false;
        }
    }
}
