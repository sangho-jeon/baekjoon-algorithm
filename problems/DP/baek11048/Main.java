package DP.baek11048;

import java.util.Scanner;

public class Main {
    static int[] dx = {-1, 0, -1};
    static int[] dy = {0, -1, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] t = sc.nextLine().split(" ");
        int N = Integer.parseInt(t[0]);
        int M = Integer.parseInt(t[1]);
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] tmp = sc.nextLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int tmp = 0;
                for (int k = 0; k < 3; k++) {
                    int tx = i + dx[k];
                    int ty = j + dy[k];
                    if(tx >= 0 && ty >= 0){
                        tmp = Math.max(tmp, map[tx][ty]);
                    }
                }
                map[i][j] += tmp;
            }
        }
        System.out.println(map[N-1][M-1]);

    }
}
