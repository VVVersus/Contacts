import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int seconds = new Scanner(System.in).nextInt();
        System.out.println(LocalTime.ofSecondOfDay(seconds));
    }
}