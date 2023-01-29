package DFS.programmers43164;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        System.out.println(Arrays.toString(solution(tickets2)));
    }
    public static String[] solution(String[][] tickets) {
        String[] answer = {};
        HashMap<String, ArrayList<String>> ticket = new HashMap<>();
        HashMap<String, Boolean> visited = new HashMap<>();
        for (String[] tmp:
             tickets) {
            String start = tmp[0];
            String end = tmp[1];
            visited.put(start, false);
            visited.put(end, false);
            ArrayList<String> stops = new ArrayList<>();
            stops = ticket.getOrDefault(start, stops);
            stops.add(end);
            ticket.put(start, stops);
        }
        for (ArrayList<String> stops:
                ticket.values()) {
            Collections.sort(stops);
        }
        System.out.println(ticket.toString());
        return answer;
    }
}
