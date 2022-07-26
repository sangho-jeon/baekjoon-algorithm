package TodaysProblem.day0726.baek1976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        String[] t = br.readLine().split(" ");
        int[] plan = new int[t.length];
        for (int i = 0; i < t.length; i++) {
            plan[i] = Integer.parseInt(t[i]);
        }

        for (int i = 1; i < plan.length; i++) {
            if(!BFS(plan[i-1]-1, plan[i]-1)){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");


    }
    public static boolean BFS(int start, int end){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[map[0].length];
        queue.add(start);
        while(!queue.isEmpty()){
            int s = queue.poll();
            visited[s] = true;
            if(s == end){
                return true;
            }
            for (int i = 0; i < map[0].length; i++) {
                if(!visited[i] && map[s][i] == 1){
                    queue.add(i);
                }
            }

        }
        return false;
    }
}
