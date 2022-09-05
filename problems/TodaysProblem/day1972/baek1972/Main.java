package TodaysProblem.day1972.baek1972;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){

            HashSet<String> strings = new HashSet<>();
            String t = br.readLine();
            char[] line = t.toCharArray();
            if(line[0] == '*'){
                return;
            }
            int N = line.length;
            boolean isSurprising = true;
            loop:
            for (int i = 0; i < N-2; i++) {
                char s = line[i];
                for (int j = i+1; j < N-1; j++) {
                    StringBuilder sb = new StringBuilder();
                    char e = line[j];
                    if(!strings.add(sb.append(s).append(e).toString())){
                        isSurprising = false;
                        break loop;
                    }
                }
            }
            if (!isSurprising) {
                System.out.println(t + " is NOT surprising.");
            } else {
                System.out.println(t + " is surprising.");
            }
        }
    }
}
