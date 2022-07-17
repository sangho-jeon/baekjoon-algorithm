package BruteForceBackTracking.baek15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int[] dx, dy;
    static int result = Integer.MAX_VALUE;
    static int N,  M;
    static ArrayList<Chicken> chickens;
    public static class Chicken {
        public Chicken(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x;
        public int y;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] t = br.readLine().split(" ");
        N = Integer.parseInt(t[0]);
        M = Integer.parseInt(t[1]);
        dx = new int[]{1, -1, 0, 0};
        dy = new int[]{0, 0, 1, -1};
        chickens = new ArrayList<Chicken>();
        map = new int[N][N];

        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(tmp[j]);
                if (map[i][j] == 2) {
                    Chicken chicken = new Chicken(i, j);
                    chickens.add(chicken);
                }
            }
        }
        int[] check = new int[chickens.size()];
        for (int i = 0; i < chickens.size(); i++) {
            check[i] = BFS(chickens.get(i));
            System.out.println(check[i]);
        }
        Combination(check, visited, 0, check.length, M);
        System.out.println(result);


    }

    public static void Combination(int[] check, boolean[] visited, int start, int n, int r){
        if(r == 0){
            int dist = 0;
            for (int i = 0; i < check.length; i++) {
                if(visited[i]){
                    dist += check[i];
                }
            }
            result = Math.min(result, dist);
        }
        else{
            for (int i = start; i < n; i++) {
                visited[i] = true;
                Combination(check, visited ,i+1, n, r-1);
                visited[i] = false;
            }
        }
    }

    public static int BFS(Chicken chicken) {
        int x = chicken.x;
        int y = chicken.y;
        int dist = 0;
        Queue<Chicken> queue = new LinkedList<>();
        queue.add(chicken);
        while (!queue.isEmpty()) {
            Chicken position = queue.poll();
            if (map[position.x][position.y] == 1) {
                int distance = Math.abs(x - position.x) + Math.abs(y - position.y);
                dist += distance;
                break;
            } else {
                for (int i = 0; i < 4; i++) {
                    Chicken nextChicken = new Chicken(position.x + dx[i], position.y + dy[i]);
                    if(nextChicken.x >= 0 && nextChicken.x < N && nextChicken.y >= 0 && nextChicken.y < N){
                        queue.add(nextChicken);
                    }
                }
            }
        }
        return dist;
    }

}
