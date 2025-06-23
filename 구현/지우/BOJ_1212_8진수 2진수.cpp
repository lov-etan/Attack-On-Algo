#include <iostream>
#include <map>

using namespace std;
// int형 10자리 

string eight[] = {"000", "001", "010", "011", "100", "101", "110", "111"};

int main() {

    string s; 
    cin >> s;

    string tmp = ""; string ans = "";

    for(int i=0; i<s.length(); i++) {
        int num = s[i] - '0';
        tmp += eight[num];
    }

    if(s[0] != '0') {
        bool deleteZero = false;
        for(int i=0; i<tmp.length(); i++) {
            if(!deleteZero && tmp[i] == '0') {
                continue;
            }
            else if(!deleteZero && tmp[i] == '1') {
                deleteZero = true;
                ans += tmp[i];
            }
            else if(deleteZero) {
                ans += tmp[i];
            }
        }

        cout << ans;
    } else {
        cout << s[0]; // 000 안되고 0 반환해야 함
    }
    
    
  
    return 0;
}