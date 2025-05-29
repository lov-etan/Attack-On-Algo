#include <iostream>
#include <deque>

using namespace std;

int main() {
    cin.tie(NULL);
    
    int N;
    cin >> N;
    
    // queue<int> q; // 와 큐는 push_back(), pop_back()이 안 먹네
    deque<int> dq; // 모든 입구에서 삽입 삭제 ㄱㄴ (큐+스택)
    
    for(int i=0; i<N; i++) {
        string s; int num;
        cin >> s;
        
        if(s=="push_back") {
            cin >> num;
            dq.push_back(num);
        } else if(s == "push_front") {
            cin >> num;
            dq.push_front(num);
        } else if(s == "pop_front") {
            if(dq.empty()) {
                cout << -1 << "\n";
            } else {
                cout << dq.front() << "\n"; 
                dq.pop_front();
            }
        } else if(s == "pop_back") {
            if(dq.empty()) {
                cout << -1 << "\n";
            } else {
                cout << dq.back() << "\n"; 
                dq.pop_back();
            }        
        } else if(s == "size") {
            cout << dq.size() << "\n";
        } else if(s == "empty") {
            if(dq.empty()) cout << 1 << "\n";
            else cout << 0 << "\n";
        } else if(s == "front") {
            if(dq.empty()) cout << -1 << "\n";
            else cout << dq.front() << "\n";
        } else if(s == "back") {
            if(dq.empty()) cout << -1 << "\n";
            else cout << dq.back() << "\n";
        } 
    }
    
}