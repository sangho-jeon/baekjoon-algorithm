package Toss.PRGMMARS60059;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] key = {{0,0,0}, {1,0,0}, {0,1,1}};
        int[][] lock = {{1,1,1}, {1,1,0}, {1,0,1}};
        System.out.println(solution.solution(key, lock));
    }
    static class Solution {
        static int N, M;
        public boolean solution(int[][] key, int[][] lock) {
            boolean answer = true;
            M = key.length;
            N = lock.length;
            HashMap<Integer[], Integer> holes = new HashMap<>();
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M; j++) {
                    if(lock[i][j] == 0){
                        Integer[] point = new Integer[2];
                        point[0] = i;
                        point[1] = j;
                        holes.put(point, 0);
                    }
                }

            }

            return answer;
        }
    }
}
