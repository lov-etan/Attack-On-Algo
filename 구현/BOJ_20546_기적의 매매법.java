import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int money1, money2, jun, sung;
    static int [] stocks = new int [14];
    public static void main(String[] args) throws IOException {
        money1 = Integer.parseInt(br.readLine());
        money2 = money1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {
            stocks[i] = Integer.parseInt(st.nextToken());

            // 준현이가 매수할 주식이 있는지 확인
            if (money1 >= stocks[i])  {
                int stock = money1 / stocks[i];
                jun += stock;
                money1 -= stock * stocks[i];
            }

            // 성민이가 매수/매도할 주식이 있는지 확인
            if (i >= 3) {
                // 매수할 주식이 있는지 확인
                if (stocks[i-3] > stocks[i-2] && stocks[i-2] > stocks[i-1]) {
                    int stock = money2 / stocks[i];
                    sung += stock;
                    money2 -= stock * stocks[i];
                // 매도할 주식이 있는지 확인
                } else if (stocks[i-3] < stocks[i-2] && stocks[i-2] < stocks[i-1]) {
                    money2 += stocks[i] * sung;
                    sung = 0;
                }
            }
            
        }

        money1 += jun * stocks[13];
        money2 += sung * stocks[13];

        System.out.println(money1 > money2 ? "BNP" : (money1 < money2 ? "TIMING" : "SAMESAME"));
    }
}