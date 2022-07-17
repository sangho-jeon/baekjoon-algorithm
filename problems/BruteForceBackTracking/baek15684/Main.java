package BruteForceBackTracking.baek15684;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[][] map;
    static int N, H, answer;
    static int result = 10000;
    static boolean finish = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] t = br.readLine().split(" ");
        N = Integer.parseInt(t[0]);
        int M = Integer.parseInt(t[1]);
        H = Integer.parseInt(t[2]);
        map = new int[H][N];
        for (int i = 0; i < M; i++) {
            String[] tmp = br.readLine().split(" ");
            int h = Integer.parseInt(tmp[0]);
            int x = Integer.parseInt(tmp[1]);
            map[h - 1][x] = 2;
            map[h - 1][x - 1] = 1;
        }
        for (int i = 0; i < 4; i++) {
            answer = i;
            DFS(0, 0);
        }
        if (result == 10000 || result == 4) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

    }

    public static void DFS(int depth, int x) {
        if (finish) {
            return;
        }
        if (depth == answer) {
            if (Check(map)) {
                finish = true;
                result = Math.min(result, depth);
            }
            return;
        } else {
            for (int i = x; i < H; i++) {
                for (int j = 0; j < N - 1; j++) {
                    if (map[i][j] == 0 && map[i][j + 1] == 0) {
                        map[i][j] = 1;
                        map[i][j + 1] = 2;
                        DFS(depth + 1, i);
                        map[i][j] = 0;
                        map[i][j + 1] = 0;
                    }
                }
            }
        }
    }

    public static boolean Check(int[][] ladder) {
        boolean isTrue = true;
        for (int i = 0; i < N; i++) {
            int index = i;

            for (int j = 0; j < H; j++) {
                if (ladder[j][index] == 1) {
                    index++;
                } else if (ladder[j][index] == 2) {
                    index--;
                }
            }
            if (index != i) {
                isTrue = false;
                break;
            }
        }
        return isTrue;
    }
}
