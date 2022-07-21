package TodaysProblem.day0720.baek9375;

//start time = 2022/07/20 - 1:05

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static boolean[] visited;
    public static int iter, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        ArrayList<Integer> out = new ArrayList<>();

        for (int i = 0; i < testCase; i++) {

            int N = Integer.parseInt(br.readLine());
            HashMap<String, Integer> dress = new HashMap<>();
            for (int j = 0; j < N; j++) {
                String tmp = br.readLine().split(" ")[1];
                dress.put(tmp, dress.getOrDefault(tmp, 0) + 1);
            }
            int theme = dress.keySet().size();
            Integer[] dresses = dress.values().toArray(new Integer[0]);
            answer = 1;
            for (Integer d:
                 dresses) {
                answer *= d+1;
            }
            out.add(answer-1);
        }
        for (int i = 0; i < out.size(); i++) {
            System.out.println(out.get(i));
        }
    }


}
