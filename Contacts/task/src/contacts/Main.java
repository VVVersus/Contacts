package contacts;


public class Main {

    public static void main(String[] args) {
        String fileName = args.length > 0 ? args[0] : null;
        //fileName = "phonebook.db";
        ContactBook contactBook = new ContactBook(fileName);
        contactBook.show();

    }
}

