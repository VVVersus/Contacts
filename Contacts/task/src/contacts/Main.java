package contacts;


import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Contact> contacts = new LinkedList<>();
    public static void main(String[] args) {
        printMenu();
        String option = null;

        while (!"exit".equals(option = scanner.nextLine().toLowerCase(Locale.US).trim())) {
            switch (option) {
                case "add":
                    add();
                    break;
                case "remove":
                    remove();
                    break;
                case "edit":
                    edit();
                    break;
                case "count":
                    count();
                    break;
                case "list":
                    list();
                    break;
                default:
                    System.out.println("Try again!");
            }
        }

    }

    private static void edit() {
        if (contacts.size() > 0) {
            list();
            System.out.println("Select a record:");
            int contactId = Integer.parseInt(scanner.nextLine()) - 1;
            System.out.println("Select a field (name, surname, number):");
            String field = scanner.nextLine().toLowerCase().trim();
            switch (field) {
                case "name":
                    System.out.println("Enter name:");
                    contacts.get(contactId).setName(scanner.nextLine().trim());
                    break;
                case "surname":
                    System.out.println("Enter surname:");
                    contacts.get(contactId).setSurname(scanner.nextLine().trim());
                    break;
                case "number":
                    System.out.println("Enter number:");
                    contacts.get(contactId).setNumber(scanner.nextLine().trim());
                    break;
                default:
                    System.out.println("Unknown field!");
            }
            System.out.println("The record updated!");
        } else {
            System.out.println("No records to edit!");
        }
    }

    private static void remove() {
        if (contacts.size() > 0) {
            list();
            System.out.println("Select a record:");
            contacts.remove(Integer.parseInt(scanner.nextLine()) - 1);
            System.out.println("The record removed!");
        } else {
            System.out.println("No records to remove!");
        }
    }

    private static void list() {
        if (contacts.size() > 0) {
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println(i + 1 + ". " + contacts.get(i).toString());
            }

        } else {
            System.out.println("No records!");
        }
    }

    private static void count() {
        System.out.println(String.format("The Phone Book has %d records.", contacts.size()));
    }

    private static void add() {
        System.out.println("Enter the name:");
        String name = scanner.nextLine();
        System.out.println("Enter the surname:");
        String surname = scanner.nextLine();
        System.out.println("Enter the number:");
        String number = scanner.nextLine();

        contacts.add(new Contact(name, surname, number));
        System.out.println("The record added.");
    }

    public static void printMenu() {
        System.out.println("Enter action (add, remove, edit, count, list, exit):");
    }

}
