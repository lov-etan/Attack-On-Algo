#include <iostream>
#include <stack>
#include <vector>

using namespace std;

int main() {

    int N = 0;
    cin >> N;

    vector<int> v(N,0);
    vector<int> answer(N,0);
    stack<pair<int,int>> st; // <높이, 인덱스>

    for(int i=0; i<N; i++) {
        int h;
        cin >> h; //높이 //9

        while(!st.empty() && st.top().first <h) {
            st.pop(); //후보지 불가 
        }

        if(!st.empty()) { //후보지 존재
            answer[i] = st.top().second;
        }

        st.push({h, i+1});
    }

    for(int i=0; i<N; i++) {
        cout << answer[i] << " ";
    }
    
    return 0;
}