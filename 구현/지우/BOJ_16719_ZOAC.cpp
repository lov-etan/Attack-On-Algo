#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {

    string s; cin >> s;
    vector<bool> visited(s.length(), false);

    for(int i=0; i<s.length(); i++) { // 출력된 문제 개수
        // 이 중에 베스트 뽑게 할 친구
        vector<pair<string, int>> v;

        for(int j=0; j<s.length(); j++) { // 추가할 문자(s[j]) 골라보자
            if(!visited[j]) {
                string curr = "";
                for(int k=0; k<s.length(); k++) {
                    if(visited[k] || k == j) {
                        curr += s[k];
                        // cout << "현재 상황 "<<  curr << "\n";
                    }
                }

                v.push_back({curr, j});
            }
        }

        sort(v.begin(), v.end()); 
        // 이 중 1번째 친구가 사전순으로 제일 best
        pair<string, int> best = v[0];
        visited[best.second] = true;
        cout << best.first << "\n";
    }
    
    return 0;
}