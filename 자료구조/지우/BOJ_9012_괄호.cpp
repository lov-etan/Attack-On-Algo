#include <iostream>
#include <stack>
#include <string>

using namespace std;

int main() {
    int T;
    cin >> T;

    for(int tc=1; tc<=T; tc++) {
        string answer = "YES";
        
        string s;
        cin >> s; 

        stack<int> stack;
        for(int i=0; i<s.length(); i++) {
            if(s[i] == '(') {
                stack.push(1);
            } else {
                if(stack.empty()) {
                    // 게임 끝
                    answer = "NO";
                    break;
                } else {
                    stack.pop();
                }
            }
        }

        if(stack.empty() && answer == "YES") {
            cout << answer << "\n";
        } else {
            cout << "NO" << "\n";
        }
    }
}