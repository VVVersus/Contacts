public class Main {

    public static void main(String[] args) {
        int counter = 0;
        for (Secret item : Secret.values()) {
            if (item.name().matches("^STAR.*")) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
/*
 At least two constants start with STAR
enum Secret {
    STAR, CRASH, START;
}*/
