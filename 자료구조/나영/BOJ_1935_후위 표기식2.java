import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[] charn;
    static double [] arr;
    static Stack<Double> stack = new Stack<>();
    static int n, answer;
    public static void main(String[] args) throws Exception {
        // A - Z = -25
        n = Integer.parseInt(br.readLine());
        arr = new double [n];
        charn = br.readLine().toCharArray();
        for (int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }
        for (int i = 0; i < charn.length; i++) {
            if (('A'-charn[i]) <= 0) {
                stack.add(arr[charn[i]-'A']);
            } else {
                Double first = stack.pop();
                Double second = stack.pop();
                switch (charn[i]) {
                    case '*':
                        stack.add(second * first);
                        break;
                    case '+':
                        stack.add(second + first);
                        break;
                    case '-':
                        stack.add(second - first);
                        break;
                    case '/':
                        stack.add(second / first);
                        break;
                }
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}