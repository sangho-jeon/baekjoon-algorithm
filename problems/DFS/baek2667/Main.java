package DFS.baek2667;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int count = 0;
    static ArrayList<Integer> counts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        int house = 0;


        for (int i = 0; i < N; i++) {
            String[] tmp = sc.nextLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    visited[i][j] = true;
                    count = 0;
                    house++;
                    DFS(i, j);
                    counts.add(count);

                }
            }
        }
        Collections.sort(counts);
        System.out.println(house);
        for (int tmp:
             counts) {
            System.out.println(tmp);
        }

    }

    public static void DFS(int x, int y) {
        count++;
        for (int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if(tx >= 0 && tx < N && ty >= 0 && ty < N && map[tx][ty] != 0 && !visited[tx][ty]){
                visited[tx][ty] = true;

                DFS(tx,ty);
            }
        }

    }
}
