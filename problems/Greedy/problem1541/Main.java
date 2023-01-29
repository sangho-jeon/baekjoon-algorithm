package Greedy.problem1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer t = new StringTokenizer(br.readLine(), "[+|-]", true);
        int result = 0;
        int tmp = Integer.parseInt(t.nextToken());
        ArrayList<Integer> numbers = new ArrayList<>();
        while (t.hasMoreElements()) {
            String nextToken = t.nextToken();
            if (!nextToken.equals("+") && !nextToken.equals("-")) {
                tmp += Integer.parseInt(nextToken);
            } else if (nextToken.equals("-")) {
                numbers.add(tmp);
                tmp = 0;
            }
        }
        numbers.add(tmp);
        result = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            result -= numbers.get(i);
        }
        System.out.println(result);
    }
}
