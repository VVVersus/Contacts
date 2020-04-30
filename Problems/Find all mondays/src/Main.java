import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        LocalDate startDate = LocalDate.of(year, month, 1);
        while (startDate.compareTo(startDate.withDayOfMonth(startDate.lengthOfMonth())) < 0) {
            if (startDate.getDayOfWeek() == DayOfWeek.MONDAY) {
                System.out.println(startDate);
            }
            startDate = startDate.plusDays(1);
        }

    }
}