package TodaysProblem.day0725.baek15656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N,M;
    static int[] numbers, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);
        numbers = new int[N];
        answer = new int[M];
        String[] t = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(t[i]);
        }
        Arrays.sort(numbers);
        StringBuilder st = new StringBuilder();
        DFS(0, st);
        System.out.println(st.toString());
    }
    public static void DFS(int depth, StringBuilder sb){
        if(depth == M){
            for (int i = 0; i < M; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
        }
        else{
            for (int i = 0; i < N; i++) {
                answer[depth] = numbers[i];
                DFS(depth+1, sb);
            }
        }
    }

}
