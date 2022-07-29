package TodaysProblem.day0729.baek15655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, M;
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);
        numbers = new int[N];
        String[] t = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(t[i]);
        }
        Arrays.sort(numbers);
        boolean[] visited = new boolean[N];
        DFS(visited, 0, 0);
    }
    public static void DFS(boolean[] visited, int start, int depth){
        if(depth == M){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < visited.length; i++) {
                if(visited[i]){
                    sb.append(numbers[i]).append(" ");
                }
            }
            System.out.println(sb);
        }
        else{
            for (int i = start; i < N; i++) {
                if(!visited[i]){
                    visited[i] = true;
                    DFS(visited, i, depth+1);
                    visited[i] = false;
                }
            }
        }
    }
}
