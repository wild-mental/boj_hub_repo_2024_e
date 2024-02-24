import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        long n = Long.parseLong((new Scanner(System.in).nextLine()));
        if (n < 3) {
            System.out.println(0);
        } else {
            long cnt = 0;
            int round = 1;
            while (n-2 > 0) {
                cnt += (n-2)*round;
                n--;
                round++;
            }
            System.out.println(cnt);
        }
        System.out.println(3);
    }
}