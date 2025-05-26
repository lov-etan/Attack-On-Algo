 #include <iostream>
 #include <queue>
 #include <string>
using namespace std;

int main() {
    cin.tie(NULL); 
    ios::sync_with_stdio(false); // c랑 연관성을 끊어서 입출력 빠르게 됨
    
    int N;
    cin >> N;

    queue<int> q;

    for(int i=0; i<N; i++) {
        string s = "";
        cin >> s;
        // cout << s << "\n";

        if(s=="push") {
            int k;
            cin >> k;
            q.push(k);
        } else if(s=="pop") {
            if(q.empty()) {
                cout << -1 << "\n";
            } else {
                int k = q.front();
                q.pop();
                cout << k << "\n";
            }
        } else if(s=="size") {
            int k = q.size();
            cout << k << "\n";
        } else if(s=="empty") {
            if(q.empty()) {
                cout << 1 << "\n";
            } else {
                cout << 0 << "\n";
            }
        } else if(s=="front") {
            if(q.empty()) {
                cout << -1 << "\n";
            } else {
                cout << q.front() << "\n";
            }
        } else if(s=="back") {
            if(q.empty()) {
                cout << -1 << "\n";
            } else {
                cout << q.back() << "\n";
            }
        }
    }
    
}