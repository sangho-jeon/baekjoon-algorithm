package DP.programmers118668;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int alp = 0;
        int cop = 0;
        int[][] problems = {{0,0,2,1,2},{4,5,3,1,2},{4,11,4,0,2},{10,4,0,4,2}};
        System.out.println(solution(alp, cop, problems));
    }
    public static int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        int a = 0;
        int c = 0;
        for (int[] nums:
             problems) {
            a = Math.max(a, nums[0]);
            c = Math.max(c, nums[1]);
        }

        int[][] dp = new int[a+1][c+1];


        for (int i = 0; i <= a; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[alp][cop] = 0;

        for (int i = alp; i <= a; i++) {
            for (int j = cop; j <= c ; j++) {
                if(i+1 <= a)
                    dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + 1);
                if(j+1 <= c)
                    dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j] + 1);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        for (int i = alp; i <= a ; i++) {
            for (int j = cop; j <= c; j++) {
                for (int k = 0; k < problems.length; k++) {
                    if(i >= problems[k][0] && j >= problems[k][1]){
                        int t1 = i + problems[k][2];
                        int t2 = j + problems[k][3];
                        if(t1 > a)
                            t1 = a;
                        if(t2 > c)
                            t2 = c;
                        dp[t1][t2] = Math.min(dp[t1][t2] , dp[i][j] + problems[k][4]);
                    }
                }
            }
        }


        return dp[a][c];
    }
}
