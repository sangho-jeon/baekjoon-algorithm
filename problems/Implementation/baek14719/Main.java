package Implementation.baek14719;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int result = 0;
        Scanner sc = new Scanner(System.in);
        String[] t = sc.nextLine().split(" ");
        int H = Integer.parseInt(t[0]);
        int W = Integer.parseInt(t[1]);
        int[][] map = new int[H][W];
        String[] tmp = sc.nextLine().split(" ");

        for (int i = 0; i < tmp.length; i++) {
            int block = Integer.parseInt(tmp[i]);
            for (int j = H-1; j >= H-block ; j--) {
                map[j][i] = 1;
            }
        }
        for (int i = H-1; i >= 0 ; i--) {
            int[] line = map[i];
            boolean flag = false;
            int water = 0;

            for (int j = 0; j < line.length; j++) {

                if(line[j] == 1){
                    if(!flag){
                        flag = true;
                    }
                    else{
                        result += water;
                        water = 0;
                    }
                }
                else if(line[j] == 0){
                    if(flag){
                        water++;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
