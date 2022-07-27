package TodaysProblem.day0727.baek1261;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[][] map;
    static int N, M, result;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tmp = sc.nextLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);
        map = new int[N][M];
        result = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            String[] t = sc.nextLine().split("");
            for (int j = 0; j < N; j++) {
                map[j][i] = Integer.parseInt(t[j]);
            }
        }

        boolean[][] visited= new boolean[N][M];
        visited[0][0] = true;
        DFS(0, 0, 0, visited);
        System.out.println(result);
    }

    public static void DFS(int x, int y, int count, boolean[][] visited) {
        if (x == N - 1 && y == M - 1) {
            result = Math.min(result, count);

        } else {
            for (int i = 0; i < 4; i++) {
                int tx = x + dx[i];
                int ty = y + dy[i];
                if (tx >= 0 && tx < N && ty >= 0 && ty < M && !visited[tx][ty]) {
                    visited[tx][ty] = true;
                    DFS(tx, ty, count + map[x][y], visited);
                    visited[tx][ty] = false;
                }
            }
        }

    }
}
