package Greedy.baek16206;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int cakeCount = Integer.parseInt(tmp[0]);
        int maxCutCount = Integer.parseInt(tmp[1]);
        int result = 0;
        ArrayList<Integer> cake10 = new ArrayList<>();
        ArrayList<Integer> cakeNot10 = new ArrayList<>();

        tmp = br.readLine().split(" ");
        for (int i = 0; i < cakeCount; i++) {
            int t = Integer.parseInt(tmp[i]);
            if (t % 10 == 0) {
                cake10.add(t);
            } else {
                cakeNot10.add(t);
            }
        }
        Collections.sort(cake10);
        for (Integer cake :
                cake10) {
            if (cake == 10) {
                result++;
            } else if (cake > 10) {
                int cut = cake / 10 - 1;
                if (cut > maxCutCount) {
                    cut = maxCutCount;
                    result += cut;
                } else {
                    result += cut + 1;
                }
                maxCutCount -= cut;
            }
//            System.out.println(cake + " cut: " + maxCutCount + " result: " + result);
        }

        for (Integer cake:
             cakeNot10) {
            if(cake > 10){
                int cut = cake / 10;
                if(cut > maxCutCount){
                    cut = maxCutCount;
                }
                maxCutCount -= cut;
                result += cut;
            }
//            System.out.println(cake + " cut: " + maxCutCount + " result" + result);
        }


        System.out.println(result);
    }
}
