package contacts;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

class ContactBook implements Serializable {
    static final Scanner scanner = new Scanner(System.in);
    private List<Contact> contacts;
    private String storageFileName = null;

    public ContactBook() {
        this.contacts = new ArrayList<>();
    }

    public ContactBook(String fileName) {
        this.storageFileName = fileName;
        try {
            this.deserialize();
        } catch (Exception e) {
            this.contacts = new ArrayList<>();
        }
    }

    private void deserialize() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(this.storageFileName);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);
        this.contacts = (ArrayList<Contact>) ois.readObject();
        System.out.printf("open %s\n\n", this.storageFileName);
        ois.close();
    }

    private void serialize() throws IOException {
        if (this.storageFileName != null) {
            FileOutputStream fos = new FileOutputStream(this.storageFileName);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this.contacts);
            oos.close();
        }
    }

    public void show() {
        this.printMenu();
        String option = null;

        while (!"exit".equals(option = scanner.nextLine().toLowerCase(Locale.US).trim())) {
            switch (option) {
                case "add":
                    this.add();
                    break;
                case "list":
                    this.list();
                    break;
                case "search":
                    this.search();
                    break;
                case "count":
                    this.count();
                    break;
                default:
                    System.out.println("Try again!");
            }
            this.printMenu();
        }
        try {
            this.serialize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printMenu() {
        System.out.print("[menu] Enter action (add, list, search, count, exit): ");
    }

    private void search() {
        String searchOption = "again";
        ArrayList<Contact> searchResults = new ArrayList<>();
        while (!"back".equals(searchOption)) {
            if ("again".equals(searchOption)) {
                System.out.print("Enter search query: ");
                String query = ".*" + scanner.nextLine().toUpperCase(Locale.US) + ".*";

                for (Contact contact : contacts) {
                    if (contact.getContactString().matches(query)) {
                        searchResults.add(contact);
                    }
                }
                if (searchResults.size() > 0) {
                    System.out.printf("Found %d result:\n", searchResults.size());
                    for (int i = 0; i < searchResults.size(); i++) {
                        System.out.println(i + 1 + ". " + searchResults.get(i).toString());
                    }
                } else {
                    System.out.println("No records found!\n");
                }
            } else {
                selectContact(searchResults.get(Integer.parseInt(searchOption) - 1));
                return;
            }
            System.out.print("\n[search] Enter action ([number], back, again): ");
            searchOption = scanner.nextLine();
        }
    }

    private void selectContact(Contact contact) {
        String option = "again";
        while (!"menu".equals(option.toLowerCase())) {
            System.out.println(contact.info());
            System.out.print("\n[record] Enter action (edit, delete, menu): ");
            option = scanner.nextLine();
            switch (option) {
                case "edit":
                    this.edit(contact);
                    break;
                case "delete":
                    this.delete(contact);
                    break;
            }
        }
    }

    private void add() {
        System.out.print("Enter the type (person, organization): ");
        String number;
        switch (scanner.nextLine().toLowerCase(Locale.US)) {
            case "person":
                System.out.print("Enter the name: ");
                String name = scanner.nextLine();
                System.out.print("Enter the surname: ");
                String surname = scanner.nextLine();
                System.out.print("Enter the birth date: ");
                String s;
                LocalDate birthDate;
                if ((s = scanner.nextLine()).isEmpty()) {
                    System.out.println("Bad birth date!");
                    birthDate = null;
                } else {
                    birthDate = LocalDate.parse(s);
                }
                System.out.print("Enter the gender (M, F): ");
                Gender gender;
                s = scanner.nextLine();
                if (s.equals("M") || s.equals("F") ) {
                    gender = Gender.valueOf(s);
                } else {
                    System.out.println("Bad gender!");
                    gender = null;
                }
                System.out.print("Enter the number: ");
                number = scanner.nextLine();
                contacts.add(new PersonContact(name, surname, birthDate, gender, number));
                break;
            case "organization":
                System.out.print("Enter the organization name: ");
                String orgName = scanner.nextLine();
                System.out.print("Enter the address: ");
                String address = scanner.nextLine();
                System.out.print("Enter the number: ");
                number = scanner.nextLine();

                contacts.add((Contact) new OrganizationContact(orgName, address, number));
                break;
            default:
                System.out.println("Unsupported select");
        }
        System.out.println("The record added.\n");
    }

    private void remove() {
        if (contacts.size() > 0) {
            list();
            System.out.print("Select a record:");
            contacts.remove(Integer.parseInt(scanner.nextLine()) - 1);
            System.out.println("The record removed!");
        } else {
            System.out.println("No records to remove!");
        }
    }

    private void delete(Contact contact) {
        contacts.remove(contact);
        System.out.println("The record removed!");
    }

    private void list() {
        if (contacts.size() > 0) {
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println(i + 1 + ". " + contacts.get(i).toString());
            }
            System.out.print("\n[list] Enter action ([number], back):");
            String option = scanner.nextLine();
            if (!"back".equals(option.toLowerCase(Locale.US))) {
                selectContact(contacts.get(Integer.parseInt(option) - 1));
            }
        } else {
            System.out.println("No records!");
        }
    }

    private void count() {
        System.out.println(String.format("The Phone Book has %d records.\n", contacts.size()));
    }

    private void info() {
        if (contacts.size() > 0) {
            list();
            System.out.print("Select a record: ");
            int contactId = Integer.parseInt(scanner.nextLine()) - 1;
            System.out.println(contacts.get(contactId).info());
        } else {
            System.out.println("No records to show!");
        }
        System.out.println();
    }

    private void edit(Contact contact) {
        System.out.printf("Select a field %s: ", contact.getFields());
        String field = scanner.nextLine();
        System.out.printf("Enter %s: ", field);
        String value = scanner.nextLine();
        if (contact.setField(field, value)) {
            System.out.println("Saved");
        } else {
            System.out.println("Something went wrong");
        }
        //selectContact(contact);
    }

    private void edit() {
        if (contacts.size() > 0) {
            list();
            System.out.print("Select a record: ");
            int contactId = Integer.parseInt(scanner.nextLine()) - 1;
            if (contacts.get(contactId).isPerson) {
                System.out.print("Select a field (name, surname, birth, gender, number): ");
                PersonContact personContact = (PersonContact) contacts.get(contactId);
                String field = scanner.nextLine().toLowerCase().trim();
                switch (field) {
                    case "name":
                        System.out.print("Enter name: ");
                        personContact.setName(scanner.nextLine().trim());
                        break;
                    case "surname":
                        System.out.print("Enter surname: ");
                        personContact.setSurname(scanner.nextLine().trim());
                        break;
                    case "birth":
                        System.out.print("Enter the birth date: ");
                        personContact.setBirthDate(LocalDate.parse(scanner.nextLine().trim()));
                        break;
                    case "gender":
                        System.out.print("Enter the gender (M, F): ");
                        personContact.setGender(Gender.valueOf(scanner.nextLine().toUpperCase(Locale.US)));
                        break;
                    case "number":
                        System.out.print("Enter number: ");
                        personContact.setNumber(scanner.nextLine().trim());
                        break;
                    default:
                        System.out.print("Unknown field!");
                }
            } else {
                System.out.println("Select a field (orgname, address, number): ");
                OrganizationContact orgContact = (OrganizationContact) contacts.get(contactId);
                String field = scanner.nextLine().toLowerCase().trim();
                switch (field) {
                    case "orgname":
                        System.out.print("Enter the organization name: ");
                        orgContact.setOrgName(scanner.nextLine().trim());
                        break;
                    case "address":
                        System.out.print("Enter the address: ");
                        orgContact.setAddress(scanner.nextLine().trim());
                        break;
                    case "number":
                        System.out.print("Enter number: ");
                        orgContact.setNumber(scanner.nextLine().trim());
                        break;
                    default:
                        System.out.println("Unknown field!");
                }
            }
            System.out.println("The record updated!\n");
        } else {
            System.out.println("No records to edit!\n");
        }
    }
}
