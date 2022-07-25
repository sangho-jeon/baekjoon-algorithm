package TodaysProblem.day0724.baek1647;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Bridge {
        int start;
        int end;
        int price;

        public Bridge(int start, int end, int price) {
            this.start = start;
            this.end = end;
            this.price = price;
        }

        public void out() {
            System.out.println("start:" + this.start + "end:" + this.end + "price:" + this.price);


        }
    }

    static int[] houses;

    public static void main(String[] args) throws IOException {
        int result = 0;
        int max = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);
        houses = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            houses[i] = i;
        }
//        PriorityQueue<Bridge> bridges = new PriorityQueue<>(new Comparator<Bridge>() {
//            @Override
//            public int compare(Bridge o1, Bridge o2) {
//                return o1.price - o2.price;
//            }
//        });
        ArrayList<Bridge> bridges = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String[] t = br.readLine().split(" ");
            Bridge bridge = new Bridge(Integer.parseInt(t[0]), Integer.parseInt(t[1]), Integer.parseInt(t[2]));
            bridges.add(bridge);
        }
        Collections.sort(bridges, new Comparator<Bridge>() {
            @Override
            public int compare(Bridge o1, Bridge o2) {
                return o1.price - o2.price;
            }
        });


        for (int i = 0; i < M; i++) {
            Bridge b = bridges.get(i);
            if (Find(b.start) != Find(b.end)) {
                Union(b.start, b.end);
                result += b.price;
                max = Math.max(max, b.price);
            }

        }
        System.out.println(result - max);
    }

    public static void Union(int a, int b) {
        a = Find(a);
        b = Find(b);
        if (a != b) {
            houses[a] = b;
        }
    }

    public static int Find(int a) {
        if (houses[a] == a) {
            return a;
        } else {
            return houses[a] = Find(houses[a]);
        }
    }
}
