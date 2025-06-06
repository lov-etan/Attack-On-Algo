#include <iostream>
#include <stack>

using namespace std;

bool isOperator(char 부호) {
        return 부호 == '+' || 부호 == '-' || 부호 == '*' || 부호 == '/';
}

int 우선순위(char 부호) {
    if( 부호 == '+' || 부호 == '-') {
        return 1;
    } else if(부호 == '(') {
        return 0;
    } else {
        return 2;
    }
}

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    string input;
    cin >> input;

    stack<char> 부호st; 
    string answer = "";

    for(int i=0; i<input.length(); i++) {
        // 1. 알파벳 
        if(input[i] >= 'A' && input[i] <= 'Z') {
            answer += input[i];
        } else if (input[i] == '(') {
            부호st.push(input[i]); 
        } else if (input[i] == ')') {
            while(부호st.top() != '(') {
                answer += 부호st.top();
                부호st.pop();
            }
            부호st.pop(); // ) 남은거 pop
        } else if (isOperator(input[i])) {
            if(부호st.empty()) {
                부호st.push(input[i]); 
            } else {
                while(!부호st.empty() && 우선순위(부호st.top()) >= 우선순위(input[i])) {
                    if(부호st.top() != '(') {
                       answer += 부호st.top();
                    }
                    부호st.pop();
                }
                부호st.push(input[i]);

                
            }
        }
    }

    while(!부호st.empty()) {
        answer += 부호st.top();
        부호st.pop();
    }

    cout << answer;
    
    return 0;
}