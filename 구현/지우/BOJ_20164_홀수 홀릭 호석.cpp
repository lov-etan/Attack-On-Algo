#include <iostream>
#include <string>
#include <vector>

using namespace std;

int big; int small;

int cntOdd(string curr) {
    int cnt = 0;
    for(int i=0; i<curr.length(); i++) {
        if(curr[i]%2 == 1) cnt++;
    }
    return cnt;
};

string plusCurr(string curr, int s, int e) {
    string ans = "";
    for(int i=s; i<=e; i++) {
        ans += curr[i];
    }
    return ans;
};

void findAns(string curr, int total) { // return <총 홀수 개수>
    
    if(curr.length() == 1) {
        total += cntOdd(curr);
        small = min(small, total);
        big = max(big, total);
        return;
    }
    else if(curr.length() == 2) {
        total += cntOdd(curr);
        int sum = curr[0]-'0' + curr[1]-'0';
        findAns(to_string(sum), total);
    }
    else if(curr.length() >= 3) {
        total += cntOdd(curr);
        for(int i=0; i<curr.length()-2; i++) {
            vector<int> tmp = {0,0,0};
            tmp[0] = stoi(plusCurr(curr, 0,i));
            
            for(int j=i+1; j<curr.length()-1; j++) {
                tmp[1] = stoi(plusCurr(curr, i+1, j));
                tmp[2] = stoi(plusCurr(curr, j+1, curr.length()-1));

                int num = 0;
                for(int c=0; c<3; c++) {
                    num += tmp[c];
                }

                findAns(to_string(num), total);

             }
        }
    }
    
}

int main() {
    string input; cin >> input;
    big = -1; small = 9876543;
    
    findAns(input, 0);

    cout << small << " " << big;
    
    return 0;
}