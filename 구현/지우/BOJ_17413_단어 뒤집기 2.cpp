// 소요시간 38분

#include <iostream>
#include <deque>

using namespace std;

deque<char> dq;

void popDq() {
    while(!dq.empty()) {
        cout << dq.front();
        dq.pop_front();
    }
}

int main() {
    string s;
    getline(cin, s);

    int idx = 0;
    while(idx < s.length()) {
        if(s[idx] == '<') {
            popDq();
            while(s[idx] != '>') {
                dq.push_back(s[idx]);
                idx++;
            }
            dq.push_back(s[idx]);
            popDq();
        }
        else if(s[idx] == ' ') {
            popDq();
            cout << ' ';
        }
        else {
            dq.push_front(s[idx]);
        }

        idx++;
    }

    popDq();
    
    return 0;
}