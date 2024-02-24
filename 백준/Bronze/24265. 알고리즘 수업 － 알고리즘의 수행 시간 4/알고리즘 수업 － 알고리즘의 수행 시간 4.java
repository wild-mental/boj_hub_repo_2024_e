import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int n = Integer.parseInt((new Scanner(System.in).nextLine()));
        System.out.println(
                Math.round((Math.pow(n, 2) - n) / 2)
        );
        System.out.println(2);
    }
}
