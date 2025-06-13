#include <iostream>
#include <vector>

using namespace std;

int main() {

    int 준현금; int 성현금; 
    cin >> 준현금; 성현금 = 준현금;
    
    int 준_현재보유주식수 = 0; 
    int 성_현재보유주식수 = 0; int upCnt = 0; int dwnCnt = 0;

    int preV = 0;
    
    for(int i=0; i<14; i++) {
        int currV;
        cin >> currV; // 오늘 가격
        
        // 준
        if(준현금 >= currV) {
            
            int 매수가능주식수 = 준현금 / currV;
            준현금  -= 매수가능주식수 * currV;
            준_현재보유주식수 += 매수가능주식수;
        }

        // 성
        if(i == 0) {
            preV = currV;
            continue;
        }

        if(upCnt == 3) {
            int 매수가능주식수 = 성현금 / currV;
            성현금  -= 매수가능주식수 * currV;
            성_현재보유주식수 += 매수가능주식수;

            upCnt = 0;
        } 

        if(dwnCnt == 3) {
            성현금 += 성_현재보유주식수 * currV;
            성_현재보유주식수 = 0;
            dwnCnt = 0;
        }

        if(preV < currV) {
            upCnt++;
            dwnCnt = 0;
        } else if(preV > currV) {
            dwnCnt++;
            upCnt = 0;
        } else {
            upCnt = 0;
            dwnCnt = 0;
        }


        preV = currV;
    }

    // 금액 비교
    int 성_총자산 = 성현금 + 성_현재보유주식수 * preV;
    int 준_총자산 = 준현금 + 준_현재보유주식수 * preV;

    if(성_총자산 < 준_총자산) {
        cout << "BNP";
    } else if(성_총자산 > 준_총자산) {
        cout << "TIMING";
    } else {
        cout << "SAMESAME";
    }
}