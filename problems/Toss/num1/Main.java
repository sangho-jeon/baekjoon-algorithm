package Toss.num1;

public class Main {
    public static void main(String[] args) {
        String s = "0";
        int answer = -1;

        ///////
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length - 3; i++) {
            StringBuilder sb = new StringBuilder();

            if (array[i] == array[i + 1] && array[i + 1] == array[i + 2]) {
                sb.append(array[i]).append(array[i + 1]).append(array[i + 2]);
                int number =  Integer.parseInt(sb.toString());
                answer = Math.max(answer, number);
            }
        }


        System.out.println(answer);
    }
}
