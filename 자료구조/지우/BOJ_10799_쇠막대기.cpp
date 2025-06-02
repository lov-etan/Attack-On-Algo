#include <iostream>
#include <stack>
using namespace std;

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    string c; 
    int cnt = 0;
    cin >> c;
    stack<int> stack;
    
    for(int i=0; i<c.length(); i++) {
        if(c[i] == '(') {
            stack.push(1);
        } else {
            stack.pop();
            if(c[i-1] == '(') {
                cnt += stack.size();
            } else {
                cnt += 1;
            }
        }
    }
    cout << cnt;
    return 0;
}