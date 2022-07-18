package Greedy.baek2212;

import java.util.*;

public class Main {
    public static class Diff{
        public int diff;
        public int index;
        public Diff(int diff, int index){
            this.diff = diff;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int K = Integer.parseInt(sc.nextLine());
        String[] tmp = sc.nextLine().split(" ");
        int[] sensor = new int[N];
        int result = 0;
        ArrayList<Diff> differences = new ArrayList<>();
        if(N == 1){
            System.out.println(0);
            return;
        }

        for (int i = 0; i < N; i++) {
            sensor[i] = Integer.parseInt(tmp[i]);
        }
        Arrays.sort(sensor);
        for (int i = 0; i < N-1; i++) {
            int diff = sensor[i+1] - sensor[i];
            int index = i+1;
            differences.add(new Diff(diff, index));
        }

        differences.sort(new Comparator<Diff>() {
            @Override
            public int compare(Diff o1, Diff o2) {
                if(o1.diff == o2.diff){
                    return o2.index - o1.index;
                }
                return o2.diff - o1.diff;
            }
        });
        ArrayList<Integer> walls = new ArrayList<>();
        for (int i = 0; i < K-1; i++) {
            walls.add(differences.get(i).index);
        }
        walls.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        int start = 0;

        for (int i = 0; i < walls.size(); i++) {
            int wall = walls.get(i);
            result += sensor[wall-1] - sensor[start];
            start = wall;
        }

        result += sensor[sensor.length-1] - sensor[start];

        System.out.println(result);






    }
}
