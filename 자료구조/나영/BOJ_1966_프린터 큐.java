import java.util.*;
import java.lang.*;
import java.io.*;
 
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
		
        int T = Integer.parseInt(br.readLine()); 
	
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
			
            int N = Integer.parseInt(st.nextToken()); // 문서의 개수
            int M = Integer.parseInt(st.nextToken());
			
            Queue<int[]> q = new LinkedList<int[]>();
			
            st = new StringTokenizer(br.readLine());
			
            for (int j=0; j<N; j++) {
                int num = Integer.parseInt(st.nextToken());
				
                q.add(new int[] {j, num});
            }
			
            int cnt = 0;
            while (true) {
                int[] a = q.poll();
                boolean isS = true; // 중요도가 높은 것이 있는지 여부
				
                for (int[] b : q) {
                    if (b[1] > a[1]) {
                        isS = false;
                        break;
                    }
                }
                
                if (isS) {
                    cnt++;
                    if (a[0] == M) break;
                } else {
                    q.add(a);
                }
            }

            sb.append(cnt).append("\n");
            
        }
        System.out.println(sb.toString());
    }
}