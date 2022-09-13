package Toss.baek1939;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static ArrayList<Node>[] graph;
    static int MAX, MIN;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        graph = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<Node>();
        }
        MAX = 0;
        MIN = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int weight = sc.nextInt();
            MIN = Math.min(MIN, weight);
            MAX = Math.max(MAX, weight);
            graph[a].add(new Node(b, weight));
            graph[b].add(new Node(a, weight));
        }
        int start = sc.nextInt();
        int end = sc.nextInt();
        int answer = 0;

        while (MIN <= MAX){
            visited = new boolean[N + 1];
            int MID = (MIN + MAX)/2;
            boolean result = BFS(start, end, MID);
            if(result){
                answer = MID;
                MIN = MID + 1;
            }
            else
                MAX = MID - 1;
        }
        System.out.println(answer);

    }

    public static boolean BFS(int start, int end, int threshold) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if(current == end)
                return true;
            ArrayList<Node> links = graph[current];
            for (int i = 0; i < links.size(); i++) {
                if (links.get(i).weight >= threshold && !visited[links.get(i).next]) {
                    queue.add(links.get(i).next);
                    visited[links.get(i).next] = true;
                }
            }
        }
        return false;
    }

}

class Node {
    int next;
    int weight;

    Node(int next, int weight) {
        this.next = next;
        this.weight = weight;
    }
}
