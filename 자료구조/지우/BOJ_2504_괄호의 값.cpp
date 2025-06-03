#include <iostream>
#include <stack>
using namespace std;

string s;
stack<pair<char, int>> st;

int calculate() {
    for(int i=0; i<s.length(); i++) {
        if(s[i] == '(' || s[i] == '[') {
            st.push({s[i],0});
        } else if(s[i] == ')') {
            if(st.empty()) return 0;
            
            if(st.top().first == '(') {
                st.pop();
                st.push({'A',2});
            } else { // 숫자 or [
                int tmp = 0;
                while(!st.empty() && st.top().first != '(') {
                    if(st.top().first == '[') {
                        return 0;
                    }
                    
                    tmp += st.top().second;
                    // cout << "() " << tmp << "\n";
                    st.pop();
                }
                if (st.empty()) return 0; 
                st.pop(); // ( 빼주기
                st.push({'A',tmp*2});
            }
        } else if(s[i] == ']') {
            if(st.empty()) return 0;
            
            if(st.top().first == '[') {
                st.pop();
                st.push({'A',3});
            } else { // 숫자 or [
                int tmp = 0;
                while(!st.empty() && st.top().first != '[') {
                    if(st.top().first == '(') {
                        return 0; // 잘못된 괄호 매칭
                    }
                    
                    tmp += st.top().second;
                    // cout << "[] " << tmp << "\n";
                    st.pop();
                }
                if (st.empty()) return 0; 
                st.pop(); // ( 빼주기
                st.push({'A',tmp*3});
            }
        }
    }

    // 괄호가 남아있으면 오류
    stack<pair<char,int>> check = st;
    while (!check.empty()) {
        if (check.top().second == 0)
            return 0;
        check.pop();
    }

    return 1;
};

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    cin >> s;
    int answer = 0;
    
    if(calculate() != 0) {
        while(!st.empty()) {
            answer += st.top().second;
            st.pop();
        }
    }  

    cout << answer;
    return 0;
}