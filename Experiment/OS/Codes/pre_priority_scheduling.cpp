#include <bits/stdc++.h>
using namespace std;

int main() {
    cout << "Enter the number of processes: ";
    int n;
    cin >> n;

    vector<pair<int, pair<pair<int, int>, string>>> v1(n);
    vector<int> remaining_bt(n);

    cout << "Enter Process ID, Priority, Arrival Time, Burst Time for each process:\n";
    for (int i = 0; i < n; i++) {
        string id;
        int at, bt, p;
        cin >> id >> p >> at >> bt;
        v1[i] = {p, {{at, bt}, id}};
        remaining_bt[i] = bt;
    }

    sort(v1.begin(), v1.end(), [](const auto &a, const auto &b) {
        return a.second.first.first < b.second.first.first;
    });

    vector<int> ct(n, 0), tat(n, 0), wt(n, 0);
    vector<bool> done(n, false);
    int time = 0, completed = 0;

    while (completed < n) {
        int j = -1;

        for (int i = 0; i < n; i++) {
            if (!done[i] && v1[i].second.first.first <= time) {
                if (j == -1 || v1[i].first < v1[j].first) {
                    j = i;
                }
            }
        }

        if (j == -1) {
            time++;
            continue;
        }

        remaining_bt[j]--;
        time++;

        if (remaining_bt[j] == 0) {
            completed++;
            ct[j] = time;
            tat[j] = ct[j] - v1[j].second.first.first;
            wt[j] = tat[j] - v1[j].second.first.second;
            done[j] = true;
        }
    }

    cout << "\nProcess\tPriority\tAT\tBT\tCT\tTAT\tWT\n";
    for (int i = 0; i < n; i++) {
        cout << v1[i].second.second << "\t" << v1[i].first << "\t\t"
             << v1[i].second.first.first << "\t" << v1[i].second.first.second << "\t"
             << ct[i] << "\t" << tat[i] << "\t" << wt[i] << endl;
    }

    double avg_tat = accumulate(tat.begin(), tat.end(), 0.0) / n;
    double avg_wt = accumulate(wt.begin(), wt.end(), 0.0) / n;

    cout << "\nAverage Turnaround Time: " << avg_tat << endl;
    cout << "Average Waiting Time: " << avg_wt << endl;

    return 0;
}
