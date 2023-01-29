package Greedy.problem10775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine()); // 게이트 수
        int P = Integer.parseInt(br.readLine()); // 비행기 수
        int[] gates = new int[G+1];
        int count = 0;
        for (int i = 0; i < P; i++) {
            int plane = Integer.parseInt(br.readLine());
            boolean canPark = false;
            for (int j = plane; j >= 1 ; j--) {
                if(gates[j] == 0){
                    canPark = true;
                    gates[j] = 1;
                    count++;
                    break;
                }
            }
            if(!canPark){
                System.out.println(count);
                break;
            }
        }
        System.out.println(count);


    }
}
