//조합(시초)
#include <iostream>
#include <vector>
#include <set>
#include <algorithm>

using namespace std;

int N; 
vector<int> arr;
vector<bool> vis;
vector<pair<int,int>> ans;
set<int> set1; set<int> set2;

bool check(vector<pair<int,int>> pics) {
    set1.clear(); set2.clear();
    
    for(int i=0; i<pics.size(); i++) {
        set1.insert(pics[i].first);
        set2.insert(pics[i].second);
    }

    return set1 == set2;
}

bool dfs(int groupSize, vector<pair<int,int>>& pics, int start) {
    if(groupSize == pics.size()) {
        if(check(pics)) {
            ans = pics;
            return true;
        }
        return false;
    }

    if(pics.size() + (N - start +1) < groupSize) { // 남은거 다 더해도 group 안돼? - 자르기 
        return false;
    }

    for(int i=start; i<=N; i++) {
        pics.push_back({i, arr[i]});
        if(dfs(groupSize, pics, i+1)) return true;
        pics.pop_back();
    }

    return false;
}

int main() {
    cin.tie(0); cout.tie(0);
    ios::sync_with_stdio(0);
    
    cin >> N;
    arr.resize(N+1);
    vis.assign(N+1, false);

    for(int i=1; i<=N; i++) {
         cin >> arr[i];
    }

    for(int i=N; i>=1; i--) { // 집합 개수
        vector<pair<int,int>> pics;
        if(dfs(i, pics, 1)) {
            break;
        }
    }

    sort(ans.begin(), ans.end());
    cout << ans.size() << "\n";
    for(int i=0; i<ans.size(); i++) {
        cout << ans[i].first << "\n";
    }
    
    
    return 0;
}