import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // read 1 line of 2 numbers from buffered reader
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        // read n lines of 2 numbers from buffered reader
        int[] w = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            w[i] = Integer.parseInt(input[0]);
            v[i] = Integer.parseInt(input[1]);
        }
        // initialize the dp array
        int[][] dp = new int[n+1][k+1];
        // fill the dp array
        for (int ni = 1; ni <= n; ni++) {
            for (int ki = 1; ki <= k; ki++) {
                if (w[ni-1] <= ki) {
                    dp[ni][ki] = Math.max(dp[ni-1][ki], dp[ni-1][ki-w[ni-1]] + v[ni-1]);
                } else {
                    dp[ni][ki] = dp[ni-1][ki];
                }
            }
        }
        // print the result
        System.out.println(dp[n][k]);
    }
}
