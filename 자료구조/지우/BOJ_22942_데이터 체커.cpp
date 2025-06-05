#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>

using namespace std;

int main() {
    int N; string answer = "YES";
    cin >> N;

    vector<pair<int, int>> v(2200000);
    stack<pair<int, int>> st;

    for(int i=1; i<=N; i++) {
        int x = 0; //원중심
        int r = 0; //반지름
        cin >> x >> r;

        int num1 = x - r + 1100000;
        int num2 = x + r + 1100000;

        if(v[num1].first != 0 || v[num2].first != 0) {
            answer = "NO";
            break;
        }

        v[num1] = {i,0};
        v[num2] = {i,1};
    }

    for(int i=0; i<v.size(); i++) {
        if(v[i].first == 0) continue;

        if(v[i].second == 0) { //괄호 들어옴 
            st.push(v[i]);
        } else { // 괄호 나감
            if(st.empty()) {
                answer = "NO";
                break;
            }
            
            int topIdx = st.top().first; 
            if(topIdx == v[i].first) {
                st.pop();
            } else {
                answer = "NO";
                break;
            }
        }
    }

    cout << answer;

    
    return 0;
}