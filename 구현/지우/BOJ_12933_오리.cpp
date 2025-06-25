#include <iostream>
#include <string>

using namespace std;

char quack[] = {'q', 'u', 'a', 'c', 'k'};

int main() {
    string s; cin >> s;
    if(s.length() < 5) {
        cout << -1 << endl;
    }

    int remain = s.length();
    int cnt = 0;
    while(remain > 0) {
        int idx = 0;
        int qidx = 0;
        bool check = false;
        int tmp[5];
        while(idx <s.length()) {
            if(s[idx] == quack[qidx]) {
                tmp[qidx++] = idx; //해당 인덱스 지워줄거임
                if(qidx == 5) {
                    check = true;
                    remain -= 5;
                    qidx = 0;
                    for(int i=0; i<5; i++) {
                        s[tmp[i]] = '\0';
                    }
                }
            }
            idx++;
        }
        if(check) cnt++;
        else break;
    }

    cout << (remain==0? cnt:-1) << endl;
    
    
    return 0;
}