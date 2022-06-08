package DP.baek1937;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[][] dp, map;
    static int N;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        map = new int[N][N];
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] tmp = sc.nextLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                DFS_DP(i, j, 0);
            }
        }
        System.out.println(Arrays.deepToString(dp));

    }

    public static void DFS_DP(int x, int y, int count) {
        System.out.println(Arrays.deepToString(dp));
        int c = count;
        for (int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[y];
            if (tx >= 0 && tx < N && ty >= 0 && ty < N) {
                if (map[tx][ty] > map[x][y]) { // 일단 갈 수 있음
                    if (dp[tx][ty] != 0) { // 안가본곳임
                        DFS_DP(tx, ty, count + 1);
                    } else {
                        c = Math.max(c, dp[tx][ty] + count + 1);
                        break;
                    }
                }
            }
        }
        dp[x][y] = Math.max(dp[x][y], c);
    }
}
