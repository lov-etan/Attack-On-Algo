// 0 ms 2156 KB

#include <iostream>
#include <stack>

using namespace std;

int main() {
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    
    int N;
    cin >> N;

    stack<int> stack;

    for(int i=0; i<N; i++) {
        string s;
        cin >> s;

        // cout << s << "\n";
        
        if(s == "push") {
            int num;
            cin >> num;
            stack.push(num);
        } else if (s == "pop") {
            if(stack.empty()) {
                cout << -1 << "\n";
            } else {
                cout << stack.top() << "\n";
                stack.pop();
            }
        } else if (s == "size") {
            cout << stack.size() << "\n";
        } else if (s == "empty") {
            if(stack.empty()) {
                cout << 1 << "\n";
            } else {
                cout << 0 << "\n";
            }
        } else if (s == "top") {
            if(stack.empty()) {
                cout << -1 << "\n";
            } else {
                cout << stack.top() << "\n";
            }
        }
    }
    
}