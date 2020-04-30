import java.util.*;

public class Main {
    public static void main(String[] args) {
        String password = new Scanner(System.in).nextLine();
        String regexAZ = ".*[A-Z]+.*";
        String regexaz = ".*[a-z]+.*";
        String regex09 = ".*\\d+.*";
        String regexLength = ".{12,}";
        System.out.println(password.matches(regexAZ)
                && password.matches(regexaz)
                && password.matches(regex09)
                && password.matches(regexLength) ? "YES" : "NO");
    }
}