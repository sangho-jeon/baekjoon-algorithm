package TodaysProblem.day0729.baek1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        boolean[] peoples = new boolean[N+1];
        int result = 0;
        int M = Integer.parseInt(tmp[1]);
        String[] t = br.readLine().split(" ");

        for (int i = 1; i <t.length; i++) {
            peoples[Integer.parseInt(t[i])] = true;
        }
        String[] cases = new String[M];
        for (int i = 0; i < M; i++) {
            cases[i] = br.readLine();
            String[] tm = cases[i].split(" ");
            boolean isCheck = false;
            for (int j = 1; j < tm.length; j++) {
                int attendence = Integer.parseInt(tm[j]);
                if(peoples[attendence]) {
                    isCheck = true;
                    break;
                }
            }
            if(isCheck){
                for (int j = 1; j < tm.length; j++) {
                    int att = Integer.parseInt(tm[j]);
                    peoples[att] = true;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            String[] tm = cases[i].split(" ");
            boolean  isCheck = false;
            for (int j = 1; j < tm.length; j++) {
                int att = Integer.parseInt(tm[j]);
                if(peoples[att]){
                    isCheck = true;
                    break;
                }
            }
            if(!isCheck){
                result++;
            }
        }
        System.out.println(result);


    }
}
