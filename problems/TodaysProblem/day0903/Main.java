package TodaysProblem.day0903;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String number = "4177252841";
        int k = 4;
        System.out.println(solution(number, k));
    }

    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        String[] tmp = number.split("");
        int[] num = new int[number.length()];
        int[] result = new int[number.length() - k];

        for (int i = 0; i < tmp.length; i++) {
            num[i] = Integer.parseInt(tmp[i]);
        }

        for (int i = 0; i < num.length; i++) {
            int start = 0;
            int end = result.length;
            if(i >= k){
                start = i - k;
            }
            for (int j = start; j < end ; j++) {
                if(result[j] < num[i]){
                    result[j] = num[i];
                    for (int l = j+1; l < result.length; l++) {
                        if(result[l] == 0)
                            break;
                        result[l] = 0;
                    }

                    break;
                }
            }
        }
        for (int a:
             result) {
            answer.append(a);
        }

        return answer.toString();
    }

}
