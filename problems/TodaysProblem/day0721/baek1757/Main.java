package TodaysProblem.day0721.baek1757;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);
        int[] D = new int[N+1];
        int[][] DP = new int[N+1][M+1];

        for (int i = 1; i < N+1; i++) {
            D[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if(j == 0){
                    for (int k = 0; k < i; k++) {
                        DP[i][j] = Math.max(DP[i-k][j], DP[i-k][0]);
                    }
                }
                else {
                    DP[i][j] = DP[i - 1][j - 1] + D[i];
                }
            }
        }
        System.out.println(DP[N][0]);

    }
}
