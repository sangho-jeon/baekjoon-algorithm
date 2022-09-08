package Toss.baek2531;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tmp = sc.nextLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int d = Integer.parseInt(tmp[1]);
        int k = Integer.parseInt(tmp[2]);
        int c = Integer.parseInt(tmp[3]);
        Queue<Integer> sushi = new LinkedList<>();
        Queue<Integer> once = new LinkedList<>();
        int answer = 0;
        HashMap<Integer, Integer> duplicate = new HashMap<>();
        int[] kind = new int[d];
        for (int i = 0; i < N; i++) {
            sushi.add(sc.nextInt());
        }
        int count = 0;

        for (int i = 0; i < N+k; i++) {
            int plate = sushi.poll();
            if(duplicate.getOrDefault(plate, 0) == 0){
                count++;
            }
            once.add(plate);
            duplicate.put(plate, duplicate.getOrDefault(plate, 0)+1);
            if(once.size() > k){
                int out = once.poll();
                if(duplicate.get(out) == 1){
                    count--;
                }
                duplicate.put(out, duplicate.get(out) - 1);
                sushi.add(out);
            }
            if(duplicate.getOrDefault(c, 0) == 0){
                answer = Math.max(answer, count+1);
            }
            else{
                answer = Math.max(answer, count);
            }
        }
        System.out.println(answer);

    }
}
