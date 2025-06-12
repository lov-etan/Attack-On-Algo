import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T;
    static StringBuilder sb;
    static char [] charn;
    static List<Character> list = new LinkedList<>();
    static ListIterator<Character> iter = list.listIterator();
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            sb = new StringBuilder();
            charn = br.readLine().toCharArray();

            list = new LinkedList<>();
            iter = list.listIterator();

            
            for (int i = 0; i < charn.length; i++) {
                if (charn[i] == '<') {
                    if (iter.hasPrevious()) iter.previous();
                }
                else if (charn[i] == '>') {
                    if (iter.hasNext()) iter.next();
                }
                else if (charn[i] == '-') {
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                } else iter.add(charn[i]);
            }

            for (Character c : list) {
                sb.append(c);
            }
            
            System.out.println(sb.toString());
            
        }
        
    }
}
