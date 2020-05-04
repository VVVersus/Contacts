import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalTime time = LocalTime.parse(scanner.nextLine());
        int hours = scanner.nextInt();
        int minutes = scanner.nextInt();

        System.out.println(time.minusHours(hours).minusMinutes(minutes));
    }
}