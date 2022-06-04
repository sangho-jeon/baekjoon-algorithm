package DP.baek12865;

import java.util.*;

public class Main {
    static class Stuff{
        public int W;
        public int V;
        public void sout(){
            System.out.println("weigth: " + this.W + " value: " + this.V);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tmp = sc.nextLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int K = Integer.parseInt(tmp[1]);
        ArrayList<Stuff> stuffs = new ArrayList<>();
        int[] backpack = new int[K+1];


        for (int i = 0; i < N; i++) {
            String[] t = sc.nextLine().split(" ");
            Stuff s = new Stuff();
            s.W = Integer.parseInt(t[0]);
            s.V = Integer.parseInt(t[1]);
            stuffs.add(s);
        }
        Collections.sort(stuffs, new Comparator<Stuff>() {
            @Override
            public int compare(Stuff o1, Stuff o2) {
                return o1.W - o2.W;
            }
        });
        for (Stuff s:
             stuffs) {
            backpack[s.W] = s.V;

        }

        for (int i = 0; i < K; i++) {
            if(backpack[i] != 0){
                for (int j = i+1; j < K+1; j++) {
                    if(backpack[j] != 0){
                        if(i + j <= K){
                            backpack[i+j] = Math.max(backpack[i+j], backpack[i] + backpack[j]);
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.stream(backpack).max().getAsInt());
    }
}
