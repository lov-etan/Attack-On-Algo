#include <iostream>
#include <stack>

using namespace std;

int main() {
    int N;
    cin >> N;

    stack<int> stack;

    int num;
    cin >> num;

    string answer = "";

    for(int i=1; i<=N; i++) {
        
        if(i != num) {
            stack.push(i);
            answer += "+\n";
        } else {
            answer += "+\n-\n";
            cin >> num; // 새로운 num의 시대

            while(!stack.empty()) {
                int nextI = stack.top(); // 다음거 top = 3 
                if(nextI == num) { 
                    stack.pop();
                    answer += "-\n";
                    cin >> num; // 새로운 num의 시대
                } else {
                    break;
                }
           }

        }
    }

    if(!stack.empty()) {
        cout << "NO";
    } else {
        cout << answer;
    }
}