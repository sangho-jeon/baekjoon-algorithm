package TodaysProblem.day0731.baek2671;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String pattern = "((100+1+)|01)+";
        Scanner sc = new Scanner(System.in);
        String ans = sc.nextLine();
        ans = Pattern.matches(pattern, ans) ? "SUBMARINE" : "NOISE";
        System.out.println(ans);
    }
}
