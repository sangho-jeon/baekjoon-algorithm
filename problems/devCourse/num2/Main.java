package devCourse.num2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 2;
        String[] queries = {"desktop1 request", "desktop2 request", "desktop3 request", "desktop3 request", "desktop1 release", "desktop3 request"};
        System.out.println(Arrays.toString(solution.solution(n, queries)));
    }
}

class Solution {
    public String[] solution(int n, String[] queries) {
        ArrayList<String> result = new ArrayList<>();
        boolean[] wasUsed = new boolean[n];
        boolean[] isUsing = new boolean[n];
        HashMap<String, Integer> computer = new HashMap<>();

        for (int i = 0; i < queries.length; i++) {
            StringBuilder sb = new StringBuilder();
            String[] tmp = queries[i].split(" ");
            String com = tmp[0];

            String request = tmp[1];

            if(Objects.equals(request, "request")){
                sb.append(com);
                if(computer.getOrDefault(com, -1) == -1){ // 한번도 할당되지 않은 컴퓨터
                    boolean t = false;
                    for (int j = 0; j < n; j++) { // 한번도 점유당하지 않은 ip
                        if(!wasUsed[j]){
                            wasUsed[j] = true;
                            isUsing[j] = true;
                            sb.append(" 192.168.0.").append(j+1);
                            computer.put(com, j);
                            t = true;
                            break;
                        }
                    }
                    if(!t){ // 다 한번씩 점유당함
                        boolean p = false;
                        for (int j = 0; j < isUsing.length; j++) {
                            if(!isUsing[j]){
                                isUsing[j] = true;
                                sb.append(" 192.168.0.").append(j);
                                computer.put(com, j);
                                p = true;
                                break;
                            }
                        }
                        if(!p)
                            sb.append(" reject");
                    }
                }
                else{
                    int num = computer.get(com);
                    if(!isUsing[num]){
                        computer.put(com, num);
                        isUsing[num] = true;
                        sb.append(" 192.168.0.").append(num);
                    }
                    else{
                        boolean t = false;
                        for (int j = 0; j < n; j++) { // 한번도 점유당하지 않은 ip
                            if(!wasUsed[j]){
                                wasUsed[j] = true;
                                isUsing[j] = true;
                                sb.append(" 192.168.0.").append(j);
                                computer.put(com, j);
                                t = true;
                                break;
                            }
                        }
                        if(!t){ // 다 한번씩 점유당함
                            boolean p = false;
                            for (int j = 0; j < isUsing.length; j++) {
                                if(!isUsing[j]){
                                    isUsing[j] = true;
                                    sb.append(" 192.168.0.").append(j);
                                    computer.put(com, j);
                                    p = true;
                                    break;
                                }
                            }
                            if(!p)
                                sb.append(" reject");
                        }
                    }
                }
                result.add(sb.toString());
            }
            else{
                int num = computer.get(com);
                isUsing[num] = false;
            }

        }
        String[] answer = new String[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
