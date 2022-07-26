package TodaysProblem.day0726.baek1987;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static String[][] map;
    static int[] dx, dy;
    static int result = 0;
    static int N, M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tmp = sc.nextLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);
        dx = new int[]{1,-1,0,0};
        dy = new int[]{0,0,1,-1};
        map = new String[N][M];
        HashMap<String, Integer> count = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map[i] = sc.nextLine().split("");
            for (int j = 0; j < M; j++) {
                count.put(map[i][j], 0);
            }
        }
        count.put(map[0][0], 1);
        boolean[][] visited = new boolean[N][M];
        DFS(0,0,0, visited, count);
        System.out.println(result+1);
    }
    public static void DFS(int x, int y, int c, boolean[][] visited, HashMap<String, Integer> count){

        boolean farther = false;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if(tx >= 0 && tx < N && ty >=0 && ty < M && count.get(map[tx][ty]) == 0 && !visited[tx][ty]){
                farther = true;
                count.put(map[tx][ty], 1);
                visited[tx][ty] = true;
                DFS(tx, ty, c+1, visited, count);
                count.put(map[tx][ty], 0);
                visited[tx][ty] = false;
            }
        }
        if(!farther){
            result = Math.max(result, c);
        }
    }

}
