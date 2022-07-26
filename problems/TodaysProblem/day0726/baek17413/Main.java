package TodaysProblem.day0726.baek17413;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tmp = sc.nextLine();
        char[] line = tmp.toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean isTag = false;
        boolean isWord = false;
        for (int i = 0; i < line.length; i++) {
            if(isTag){
                sb.append(line[i]);
            }
            else{
                if(line[i] == ' ' || line[i] == '<'){
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(line[i]);
                }
                else{
                    stack.push(line[i]);
                }
            }

            if(line[i] == '<'){
                isTag = true;

            }
            else if(line[i] == '>'){
                isTag = false;

            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb);

    }
}
