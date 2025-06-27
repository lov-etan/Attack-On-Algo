#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

vector<int> days;

int main() {
    days.resize(366);
    int ans = 0; //면적

    int N; cin >> N;
    int minStart = 0; int maxEnd = 0;
    for(int i=0; i<N; i++) {
        int start; int end;
        cin >> start >> end;
        minStart = min(start, minStart);
        maxEnd = max(end, maxEnd);

        for(int j=start; j<=end; j++) { // 최대 1000 * 365
            days[j]++;
        }
    }

    int i=minStart;
    while(i <= maxEnd && i <366) { // 최대 365
        int dayCnt = 0; //연속된 날짜들
        int maxSchedule = 0; // 1day에 제일 많이 쌓인 일정 수

        while(days[i] > 0 && i <366) {
            maxSchedule = max(days[i], maxSchedule);
            dayCnt++;
            i++;
        }

        ans += dayCnt * maxSchedule;

        i++;
    }

    cout << ans;

    return 0;
}