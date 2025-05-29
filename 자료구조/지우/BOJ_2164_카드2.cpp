// 메모리: 4040 KB 시간: 4 ms

#include <iostream>
#include <queue>

using namespace std;

int main() {
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    
    int N;
    cin >> N;

    queue<int> q;

    for(int i=1; i<=N; i++) {
        q.push(i);
    }

    while(q.size() > 1) { 
        q.pop(); // 제일 위에 걸 버린다

        int num = q.front(); // 그 다음, 제일 위에 있는 카드를 제일 아래로 옮긴다.
        q.pop();
        q.push(num);

    }

    cout << q.front();
}