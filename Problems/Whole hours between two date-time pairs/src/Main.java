import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime first = LocalDateTime.parse(scanner.nextLine());
        LocalDateTime second = LocalDateTime.parse(scanner.nextLine());

        System.out.println(Math.abs((first.getDayOfYear() * 24 * 60 + first.getHour() * 60 + first.getMinute()
                - (second.getDayOfYear() * 24 * 60 + second.getHour() * 60 + second.getMinute())) / 60));
    }
}