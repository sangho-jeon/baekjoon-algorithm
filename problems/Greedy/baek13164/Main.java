package Greedy.baek13164;

import java.util.*;

public class Main {
    public static class Diff{
        public int index;
        public int diff;
        public Diff(int index, int diff){
            this.diff = diff;
            this.index = index;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        String[] tmp = sc.nextLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int K = Integer.parseInt(tmp[1]);
        int[] childs = new int[N];
        String[] t = sc.nextLine().split(" ");
        ArrayList<Diff> diff = new ArrayList<>();
        ArrayList<Diff> wall = new ArrayList<>();
        for (int i = 0; i < t.length; i++) {
            childs[i] = Integer.parseInt(t[i]);
            if(i>0){
                int d = childs[i] - childs[i-1];
                int index = i;
                Diff diff1 = new Diff(index, d);
                diff.add(diff1);
            }
        }
        diff.sort(new Comparator<Diff>() {
            @Override
            public int compare(Diff o1, Diff o2) {
                return o2.diff - o1.diff;
            }
        });

        for (int i = 0; i < K-1; i++) {
            wall.add(diff.get(i));
        }
        wall.sort(new Comparator<Diff>() {
            @Override
            public int compare(Diff o1, Diff o2) {
                return o1.index - o2.index;
            }
        });
        int start = 0;
        for (int i = 0; i < wall.size(); i++) {
            Deque<Integer> child = new LinkedList<>();
            int p = wall.get(i).index;
            for (int j = start; j < p; j++) {
                child.add(childs[j]);
            }
            result += child.getLast() - child.getFirst();
            start = p;
        }
        result += childs[childs.length-1] - childs[start];

        System.out.println(result);



    }
}
