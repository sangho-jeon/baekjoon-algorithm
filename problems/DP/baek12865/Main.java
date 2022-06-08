package DP.baek12865;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tmp = sc.nextLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int K = Integer.parseInt(tmp[1]);
        int[] V = new int[N];
        int[] W = new int[N];
        int[][] dp = new int[N+1][K+1];
        for (int i = 0; i < N; i++) {
            String[] t = sc.nextLine().split(" ");
            W[i] = Integer.parseInt(t[0]);
            V[i] = Integer.parseInt(t[1]);
        }
        int max = 0;

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < K+1; j++) {
                if(j < W[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - W[i-1]] + V[i-1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max);
    }
}
