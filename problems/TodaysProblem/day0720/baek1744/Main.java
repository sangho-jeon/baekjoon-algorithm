package TodaysProblem.day0720.baek1744;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

//start time = 2:00
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(sc.nextLine());
            if(t> 0){
                positive.add(t);
            }
            else{
                negative.add(t);
            }
        }
        positive.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        negative.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int start = 0;
        int result = 0;

        while(start < positive.size()-1){
            result += positive.get(start)*positive.get(start+1);
            start+=2;
        }
        if (positive.size() % 2 == 1) {
            result += positive.get(positive.size()-1);
        }
        if(negative.size() > 0 && negative.get(0) == 0){
            for (int i = 1; i < negative.size()-1; i++) {
                result += negative.get(i);
            }
        }
        else{
            for (int i = 0; i < negative.size(); i++) {
                result += negative.get(i);
            }
        }
        System.out.println(result);
    }
}
