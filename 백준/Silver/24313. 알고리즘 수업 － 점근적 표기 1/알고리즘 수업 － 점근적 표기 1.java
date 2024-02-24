import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] f = scanner.nextLine().split("\\s");
        int fn = Integer.parseInt(f[0]);
        int g = scanner.nextInt();
        int c = scanner.nextInt();
        int fc = fn*c + Integer.parseInt(f[1]);
        if (fc <= g*c && fn <= g) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
