import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static String s;
    static Map<String, Integer> map = new TreeMap<>();
    static StringBuilder sb = new StringBuilder();
    static Set<String> keySet;
    static String [] sample;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            sample = br.readLine().split("\\.");

            map.put(sample[1], map.getOrDefault(sample[1], 0)+1);
        }

        keySet = map.keySet();

        for (String key : keySet) {
            sb.append(key).append(" ").append(map.get(key)).append("\n");
        }
        
        System.out.println(sb.toString());
    }
}
