import java.util.*;

public class Main {
    public static void main(String[] args) {
        String address = new Scanner(System.in).nextLine();
        String regex = "(1?\\d{1,2}|2[0-5]{2})(\\.(1?\\d{1,2}|2[0-5]{2})){3}";
        System.out.println(address.matches(regex) ? "YES" : "NO");
    }
}