import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime date = LocalDateTime.parse(scanner.nextLine());
        int minutes = scanner.nextInt();
        date = date.plusMinutes(minutes);
        System.out.println(date.getYear() + " " + date.getDayOfYear() + " " + date.toLocalTime());
    }
}