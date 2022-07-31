package TodaysProblem.day0731.baek2660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i == j){
                    map[i][j] = 0;
                }
                else{
                    map[i][j] = 100000;
                }
            }
        }
        while (true) {
            String[] tmp = br.readLine().split(" ");
            if (Integer.parseInt(tmp[0]) == -1) {
                break;
            } else {
                int x = Integer.parseInt(tmp[0]) - 1;
                int y = Integer.parseInt(tmp[1]) - 1;

                map[x][y] = 1;
                map[y][x] = 1;
            }
        }


        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
        int[] answer = new int[N];
        int p = 1000000;
        int c = 0;
        for (int i = 0; i < N; i++) {
            int[] t = map[i];
            int result = Arrays.stream(t).max().getAsInt();
            answer[i] = result;
            p = Math.min(p, result);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if(answer[i] == p){
                c++;
                sb.append(i+1).append(" ");
            }
        }
        System.out.println(p + " " + c);
        System.out.println(sb);

    }
}
