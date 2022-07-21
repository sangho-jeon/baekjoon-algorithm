package TodaysProblem.day0721.baek1749;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] t = sc.nextLine().split(" ");
        int N = Integer.parseInt(t[0]);
        int M = Integer.parseInt(t[1]);
        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] tmp = sc.nextLine().split(" ");
            for (int j = 0; j < tmp.length; j++) {
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(j > 0){
                    map[i][j] += map[i][j-1];
                }
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(j > 0){
                    map[j][i] += map[j-1][i];
                }
            }
        }


        System.out.println(Arrays.deepToString(map));
    }
}
