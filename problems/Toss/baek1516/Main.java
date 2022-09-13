package Toss.baek1516;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] time, depth, answer;
    static ArrayList<Integer>[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        time = new int[n + 1];
        parent = new ArrayList[n + 1];
        depth = new int[n+1];
        answer = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            parent[i] = new ArrayList<>();
        }

        for (int i = 1; i < n + 1; i++) {
            String[] tmp = sc.nextLine().split(" ");
            time[i] = Integer.parseInt(tmp[0]);
            int count = 0;
            for (int j = 1; j < tmp.length; j++) {
                int build = Integer.parseInt(tmp[j]);
                if (build != -1) {
                    parent[build].add(i);
                    count++;
                }
            }
            depth[i] = count;
        }
        sort();
        for (int i = 1; i < n+1; i++) {
            System.out.println(answer[i]);
        }
    }

    public static void sort(){
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < depth.length; i++) {
            if(depth[i] == 0){
                queue.offer(i);
                answer[i] = time[i];
            }
        }
        while(!queue.isEmpty()){
            int current = queue.poll();
            for (int i = 0; i < parent[current].size(); i++) {
                int next = parent[current].get(i);
                answer[next] = Math.max(answer[next], answer[current] + time[next]);
                depth[next]--;
                if(depth[next] == 0){
                    queue.add(next);
                }
            }
        }

    }




}
