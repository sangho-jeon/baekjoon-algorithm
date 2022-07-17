package DP.baek2624;

import java.util.*;

public class Main {
    public static class Temp{
        private int n;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N = sc.nextInt();
        int[] p = new int[N];
        int[] n = new int[N];
        String ters = "sdfsdf";

        for (int i = 0; i < N; i++) {
            String[] tmp = sc.nextLine().split(" ");
            if(Objects.equals(tmp[0], tmp[1]))
            p[i] = Integer.parseInt(tmp[0]);
            n[i] = Integer.parseInt(tmp[1]);
        }
        HashSet<Integer> skfgnlk = new HashSet<>();
        HashMap<Integer, ArrayList<Integer>> tmp = new HashMap<>();
        Queue<Integer> dfsv = new LinkedList<>();
        Stack<Integer> dsf = new Stack<>();
        PriorityQueue<Integer> dsddddd = new PriorityQueue<>();
        String string = "ssdv";




        ArrayList<Integer> t = new ArrayList<>();
        t.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

    }
}
