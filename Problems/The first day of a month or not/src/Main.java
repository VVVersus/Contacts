import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int days = scanner.nextInt();
        scanner.close();

        LocalDate date = LocalDate.ofYearDay(year, days);
        System.out.println(date.compareTo(date.withDayOfMonth(1)) == 0);
    }
}