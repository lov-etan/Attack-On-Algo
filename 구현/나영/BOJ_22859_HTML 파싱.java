import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static Scanner sc = new Scanner(System.in);
    static String s;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        s = sc.nextLine();
        String example[] = s.split("title=\"");
        
        for(int i = 1; i < example.length; i++) {
            sb.append("title : ").append(example[i].substring(0, example[i].indexOf("\""))).append("\n");
            String example2 [] = example[i].split("<p>");
            for (int j = 1; j < example2.length; j++) find(example2[j].substring(0, example2[j].length()-4));
        }
        
        System.out.println(sb.toString());
    }

    static void find(String sample) {
        sample = sample.trim();
        for (int i = 0; i < sample.length(); i++) {
            if (sample.charAt(i) == '<') {
                while(i < sample.length() && sample.charAt(i) != '>') {
                    i++;
                }
            } else {
                if (sample.charAt(i) == ' ' && sb.charAt(sb.length()-1) == ' ') continue;
                sb.append(sample.charAt(i));
            }
        }
        if (sb.charAt(sb.length()-1) == ' ') sb.deleteCharAt(sb.length()-1);
        sb.append("\n");
    }
}
