import java.util.Scanner;

public class Utility {
    public static int prompt(String message) {
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
