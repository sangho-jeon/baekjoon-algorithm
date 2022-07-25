package TodaysProblem.day0725.baek10974;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static boolean[] visited;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        visited = new boolean[N];
        int[] answer = new int[N];
        DFS(0, answer);
    }
    public static void DFS(int depth, int[] queue){
        if(depth == N){
            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < N; i++) {
                answer.append(queue[i]+1).append(" ");
            }
            answer.deleteCharAt(answer.length()-1);
            System.out.println(answer);
        }
        else{
            for (int i = 0; i < N; i++) {
                if(!visited[i]){
                    visited[i] = true;
                    queue[depth] = i;
                    DFS(depth+1, queue);
                    visited[i] = false;
                }
            }
        }
    }
}
