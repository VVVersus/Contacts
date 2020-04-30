import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDate date = LocalDate.parse(scanner.nextLine());
        int offset = scanner.nextInt();
        LocalDate lastDate = date.withMonth(12).withDayOfMonth(31);
        while (date.compareTo(lastDate) <= 0) {
            System.out.println(date);
            date = date.plusDays(offset);
        }
    }
}