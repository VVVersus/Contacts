import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        LocalTime time = LocalTime.parse(new Scanner(System.in).nextLine());
        System.out.println(time.withSecond(0));
    }
}