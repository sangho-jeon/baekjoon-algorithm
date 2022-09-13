package Toss.programmers;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};
        System.out.println(solution(m, n , puddles));
    }

    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[n+1][m+1];
        for (int i = 0; i < puddles.length; i++) {
            map[puddles[i][0]][puddles[i][1]] = -1;
        }
        map[1][1] = 1;
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(map[i][j] != -1){
                    int a = map[i-1][j];
                    int b = map[i][j-1];
                    if(a > 0) map[i][j] += a % 1000000007;
                    if(b > 0) map[i][j] += b % 1000000007;
                }
//                System.out.println(Arrays.deepToString(map));
            }
        }
        answer = map[n][m]  % 1000000007;

        return answer;
    }
}
