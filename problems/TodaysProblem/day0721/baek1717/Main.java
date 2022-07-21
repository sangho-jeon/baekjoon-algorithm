package TodaysProblem.day0721.baek1717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] t = br.readLine().split(" ");
        int N = Integer.parseInt(t[0]);
        int M = Integer.parseInt(t[1]);
        array = new int[N+1];
        ArrayList<String> answer = new ArrayList<>();

        for (int i = 0; i < N+1; i++) {
            array[i] = i;
        }

        for (int i = 0; i < M; i++) {
            t = br.readLine().split(" ");
            int command = Integer.parseInt(t[0]);
            int a = Integer.parseInt(t[1]);
            int b = Integer.parseInt(t[2]);
            if(command == 0){ // union
                union(a, b);
            }
            else{
                if (find(a) == find(b)) {
                    answer.add("YES");
                }
                else{
                    answer.add("NO");
                }
            }
        }

        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }
    public static int find(int a){
        if(array[a] == a){
            return a;
        }
        return array[a] = find(array[a]);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b){
            array[b] = a;
        }

    }
}
