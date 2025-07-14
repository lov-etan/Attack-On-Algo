#include <iostream>
#include <vector>

using namespace std;

int N; int ans = -1;
vector<vector<int>> childs;

void dfs(int curr, bool containLast) {

    if(curr == -1) return;
    
    int left = childs[curr][0];
    int right = childs[curr][1];

    ans++; // 현재 노드에 도달
    
    dfs(left, false); // 왼쪽 - 무조건 왕복
    if(containLast) dfs(right, true); // 마지막 노드 포함 경로, 오른쪽은 편도만 이동
    else {
        ans++; // 왕복까지 포함
        dfs(right, false); 
    }


    return;
}


int main() {    
    cin >> N;
    childs.assign(N+1, vector<int>(2,0));

    for(int i=0; i<N; i++) {
        int a; int b; int c;
        cin >> a >> b >> c;

        childs[a][0] = b; 
        childs[a][1] = c;    
    }

    dfs(1,true); // 어차피 containLast 경로는 루트로부터 시작되니까 true로 넘기고, 들어가면 left, right(containLast경로=True)로 쪼갠다.
    cout << ans;
    
    return 0;
}