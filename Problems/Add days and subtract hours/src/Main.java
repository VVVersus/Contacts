import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        String[] s = new Scanner(System.in).nextLine().split("\\s+");
        LocalDateTime dateTime = LocalDateTime.parse(s[0]);
        int days = Integer.parseInt(s[1]);
        int hours = Integer.parseInt(s[2]);
        System.out.println(dateTime.plusDays(days).minusHours(hours));
    }
}