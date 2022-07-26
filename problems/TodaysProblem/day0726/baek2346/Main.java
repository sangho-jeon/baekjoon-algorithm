package TodaysProblem.day0726.baek2346;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        LinkedList<Integer> balloon = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int[] jumps = new int[N];
        String[] tmp = sc.nextLine().split(" ");
        for (int i = 0; i < N; i++) {
            balloon.add(i);
            jumps[i] = Integer.parseInt(tmp[i]);
        }
        int index = 0;
        while(balloon.size() > 1){
            System.out.println(balloon.toString());
            sb.append(balloon.get(index)+1).append(" ");
            int jump = jumps[balloon.get(index)];
            balloon.remove(index);


            if(jump > 0){
                index = ((index+jump-1) % balloon.size());
            }
            else{
                index = balloon.size() + ((index + jump) % balloon.size());
            }

        }
        System.out.println(sb);
    }
}
