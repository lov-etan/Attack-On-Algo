#include <iostream>
#include <stack>
#include <vector>
#include <set>

using namespace std;

string input; 
set<string> results;
vector<pair<int, int>> v; // 괄호쌍 인덱스 <(의idx,)의idx >
void comb(int dpth, vector<bool> visited);

int main() {
    cin >> input;
    stack<char> stack;

    for(int i=0; i<input.length(); i++) {
        if(input[i] == '(') {
            stack.push(i);
        } else if(input[i] == ')') {
            v.push_back({stack.top(), i});
            stack.pop();
        }
    }
 
    // 괄호쌍을 넣는 ver, 안 넣는 ver로 재귀 돌리기
    // 얼만큼? 괄호쌍이 있는 만큼!

    vector<bool> visited(input.size()); //방문을 한 친구만 빼는 용도
    comb(0, visited); 

    for(auto result: results) {
        cout << result << "\n";
    }
    
    return 0;
}

void comb(int depth, vector<bool> visited) {

    if(depth == v.size()) {
        int cnt = 0;
        for(int i=0; i<visited.size(); i++) {
            if(visited[i]) {
                cnt++;
            }
        }
        if(cnt == 0) return;

        string answer = "";
        for(int i=0; i< input.length(); i++) {
            if(!visited[i]) {
                answer += input[i];
            }
        }
        results.insert(answer);
        return;
    }

    // 1. 아예 visited가 없는 상태로 오겠지
    // 제일 첫번째 쌍부터 방문하고 다음 턴으로 넘기자 

    visited[v[depth].first] = true;
    visited[v[depth].second] = true;
    comb(depth+1, visited);
    
    visited[v[depth].first] = false;
    visited[v[depth].second] = false;
    comb(depth+1, visited);
}