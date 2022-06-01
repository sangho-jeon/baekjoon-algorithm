package BruteForceBackTracking.paek14889;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static int N;
    static ArrayList<Integer> results = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());

        int[][] S = new int[N][N];
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            String[] tmp = sc.nextLine().split(" ");
            for (int j = 0; j < tmp.length; j++) {
                S[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        DFS(S, 0, visited, 0);

        Collections.sort(results);
        System.out.println(results.get(0));
    }

    public static void DFS(int[][] S, int count, boolean[] visited, int idx) {
        if (count == N / 2) {
            int start = 0;
            int link = 0;
            for (int i = 0; i < visited.length-1; i++) {
                for (int j = i+1; j < visited.length; j++) {
                    if(visited[i] && visited[j]){
                        start += S[i][j];
                        start += S[j][i];
                    }
                    else if(!visited[i] && !visited[j]){
                        link += S[i][j];
                        link += S[j][i];
                    }
                }
            }
            results.add(Math.abs(start-link));
        } else {
            for (int i = idx; i < visited.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    DFS(S, count + 1, visited, i+1);
                    visited[i] = false;
                }
            }
        }
    }
}
