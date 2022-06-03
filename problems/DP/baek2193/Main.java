package DP.baek2193;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] zero = new long[N+1];
        long[] one = new long[N+1];

        zero[0] = 0;
        zero[1] = 0;
        one[0] = 0;
        one[1] = 1;

        for (int i = 2; i <= N; i++) {
            zero[i] = zero[i-1] + one[i-1];
            one[i] = zero[i-1];
        }
        System.out.println(one[N] + zero[N]);

    }
}
