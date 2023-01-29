package Greedy.problem16496;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        ArrayList<String> numbers = new ArrayList<>();
        String[] tmp = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numbers.add(tmp[i]);
        }

        Collections.sort(numbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
//                int idx = 0, idy = 0;
//                if (Arrays.equals(o1, o2)) {
//                    return 0;
//                }
//                while (o1[idx] == o2[idy]) {
//                    if (o1.length - 1 > idx) idx++;
//                    if (o2.length - 1 > idy) idy++;
//                }
//                return o2[idy] - o1[idx];
                return - (o1 + o2).compareTo(o2 + o1);
            }
        });

        boolean flag = true;
        for (String t :
                numbers) {
            if(!Objects.equals(t, "0")){
                flag = false;
            }
            sb.append(t);
        }

        if(flag){
            System.out.println("0");
        }
        else {
            System.out.println(sb.toString());
        }
    }
}
