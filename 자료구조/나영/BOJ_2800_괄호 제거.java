import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String s, s2;
    static Stack<Integer> stack = new Stack<>();
    static List<int []> list = new ArrayList<>();
    static boolean [] visited;
    // 사전순 정렬을 보장해주는 자료구조 사용
    static Set<String> set = new TreeSet<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        s = br.readLine();

        // 괄호의 인덱스를 list에 순서대로 저장
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') stack.add(i);
            else if (c == ')') list.add(new int [] {stack.pop(), i});
        }

        visited = new boolean [s.length()];

        s2 = s;
        
        find(0, s.toCharArray());

        for (String result : set) sb.append(result).append("\n");
        
        System.out.println(sb.toString());
    }

    static void find (int cnt, char [] charn) {
        // 만약 모든 괄호를 체크했다면
        if (cnt == list.size()) {
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < charn.length; i++) {
                if (visited[i]) continue;
                sb2.append(charn[i]);
            }
            if(!sb2.toString().equals(s)) set.add(sb2.toString());
            return;
        }

        int [] arr = list.get(cnt);
        visited[arr[0]] = true;
        visited[arr[1]] = true;
        find(cnt+1, charn);
        visited[arr[0]] = false;
        visited[arr[1]] = false;
        find(cnt+1, charn);
        
    }
}
