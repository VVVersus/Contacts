import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        LocalDate startDate = LocalDate.of(year, month, 1);
        System.out.println(startDate + " " + startDate.withDayOfMonth(startDate.lengthOfMonth()));
    }
}