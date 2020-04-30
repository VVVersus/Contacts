import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("password[\\s:]+([a-z0-9])+\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            do {
                String[] s = matcher.group().split("[\\s:]+");
                System.out.println(s[s.length - 1]);
            } while (matcher.find());
        } else {
            System.out.println("No passwords found.");
        }
    }
}