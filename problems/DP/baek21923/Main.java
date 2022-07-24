package DP.baek21923;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);
        int[][] map = new int[N][M];
        int[][] up = new int[N][M];
        int[][] down = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] t = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(t[j]);
            }
        }
        up[N-1][0] = map[N-1][0];
        for (int i = N-2; i >= 0; i--) {
            up[i][0] = up[i+1][0] + map[i][0];
        }
        for (int i = 1; i < M; i++) {
            up[N-1][i] = up[N-1][i-1] + map[N-1][i];
        }

        for (int i = N-2; i >= 0; i--) {
            for (int j = 1; j < M; j++) {
                up[i][j] = Math.max(up[i+1][j], up[i][j-1]) + map[i][j];
            }
        }

        down[N-1][M-1] = map[N-1][M-1];
        for (int i = N-2; i >= 0; i--) {
            down[i][M-1] = down[i+1][M-1] + map[i][M-1];
        }
        for (int i = M-2; i >= 0 ; i--) {
            down[N-1][i] = down[N-1][i+1] + map[N-1][i];
        }

        for (int i = N-2; i >= 0; i--) {
            for (int j = M-2; j >= 0 ; j--) {
                down[i][j] = Math.max(down[i+1][j], down[i][j+1]) + map[i][j];
            }
        }

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!(i==N-1 && j==0) || !(i==N-1 && j == M-1))
                    result = Math.max(result, down[i][j] + up[i][j]);
            }
        }


        System.out.println(result);

    }
}
