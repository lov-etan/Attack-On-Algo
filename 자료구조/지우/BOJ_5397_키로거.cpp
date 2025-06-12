#include <iostream>
#include <stack>

using namespace std;

int main() {
    int T;
    cin >> T;

    for(int tc=1; tc<=T; tc++) {
        string input;
        cin >> input;

        stack<char> st;
        stack<char> tmpSt;

        for(int i=0; i<input.length(); i++) {
            char c = input[i];

            if(c == '-') {
                if(!st.empty()) {
                    st.pop();
                }
            }
            else if(c == '<') {
                if(!st.empty()) {
                    tmpSt.push(st.top());
                    st.pop();
                }
            }
            else if(c == '>') {
                if(!tmpSt.empty()) {
                    st.push(tmpSt.top());
                    tmpSt.pop();
                }
            }
            else {
                st.push(c);
            }
        }

        while(!tmpSt.empty()) {
            st.push(tmpSt.top());
            tmpSt.pop();
        }

        stack<char> tmp;
        while(!st.empty()) {
            tmp.push(st.top());
            st.pop();
        }

        while(!tmp.empty()) {
            cout << tmp.top();
            tmp.pop();
        }
        cout << "\n";
    }
    
    return 0;
}