import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.parse(new Scanner(System.in).nextLine());
        System.out.println((dateTime.getDayOfYear() - 1) * 24 + dateTime.getHour());
    }
}