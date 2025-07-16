import java.util.*;
import java.lang.*;
import java.io.*;

class P {
    boolean isFolder;
    String name;

    public P (String name, int isFolder) {
        this.isFolder = (isFolder == 1);
        this.name = name;
    }
}

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, m, q, c, cnt;
    static String query, a, b;
    static String sample [];
    static Set<String> set;
    static Map<String, List<P>> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            a = st.nextToken();
            b = st.nextToken();
            c = Integer.parseInt(st.nextToken());
            if (map.get(a) == null) {
                List<P> list = new ArrayList<>();
                list.add(new P(b, c));
                map.put(a, list);
            } else {
                // List<P> list = map.get(a).add(new P(b, c));
                map.get(a).add(new P(b, c));
                // map.put(a, list);
            }
        }

        q = Integer.parseInt(br.readLine());

        for (int i = 0; i < q; i++) {
            cnt = 0;
            set = new HashSet<>();
            query = br.readLine();
            sample = query.split("/");

            find(sample[sample.length-1]);

            sb.append(set.size()).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    static void find(String s) {
        List<P> list = map.get(s);
        if (list == null) return;

        for (P p : list) {
            // 폴더이면 하위 자료 찾으러 떠남
            if (p.isFolder) find(p.name);
            // 아니면 cnt++하고 set에 해당 파일을 더함
            else {
                cnt++;
                set.add(p.name);
            }
        }
    }
}
