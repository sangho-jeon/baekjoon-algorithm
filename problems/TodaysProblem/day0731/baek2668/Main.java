package TodaysProblem.day0731.baek2668;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        array = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        int result = 0;

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i < N + 1; i++) {
            boolean[] visited = new boolean[N + 1];
            int p = find(i, array[i], 1, visited);
            if(p != 0){
                result++;
                ans.add(p);
            }
        }
        ans.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        System.out.println(result);
        for (Integer a:
             ans) {
            System.out.println(a);
        }


    }

    public static int find(int start, int a, int count, boolean[] visited) {
        if (a == start) {
            return a;
        }
        else if (array[a] == start) {
            return a;
        } else {
            if(!visited[array[a]]){
                visited[array[a]] = true;
                return find(start, array[a], count+1, visited);
            }
            else return 0;
        }
    }
}
