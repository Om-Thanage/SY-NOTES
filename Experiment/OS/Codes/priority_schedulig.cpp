#include <bits/stdc++.h>
using namespace std;

int main(){
    cout<<"Enter the number of processes: ";
    int n;    cin>>n;

    vector<pair<int, pair<pair<int, int>, string>>> v1(n);

    cout << "Enter Process ID, Priority, Arrival Time, Burst Time for each process:\n";
    for (int i = 0; i < n; i++) {
        string id;
        int at, bt, p;
        cin>>id>>p>>at>>bt;
        v1[i] = {p, {{at, bt}, id}};
    }

    sort(v1.begin(), v1.end(), [](const auto &a, const auto &b) {
        return a.second.first.first < b.second.first.first;
    });

    vector<int> ct(n), tat(n), wt(n);
    int temp = 0;
    vector<bool> done(n, false);

    for (int comp = 0; comp < n; comp++) {
        int j = -1;

        for (int i = 0; i < n; i++) {
            if (!done[i] && v1[i].second.first.first <= temp) {
                if (j == -1 || v1[i].first < v1[j].first) {
                    j = i;
                }
            }
        }

        if (j == -1) {
            for (int i = 0; i < n; i++) {
                if (!done[i]) {
                    temp = v1[i].second.first.first;
                    break;
                }
            }
            comp--;
            continue;
        }

        int at = v1[j].second.first.first;
        int bt = v1[j].second.first.second;

        temp = max(temp, at) + bt;
        ct[j] = temp;
        tat[j] = ct[j] - at;
        wt[j] = tat[j] - bt;
        done[j] = true;
    }

    cout<<"\nProcess\tPriority\tAT\tBT\tCT\tTAT\tWT\n";
    for (int i = 0; i < n; i++) {
        cout<<v1[i].second.second<<"\t"<<v1[i].first<<"\t\t"
            <<v1[i].second.first.first<<"\t"<<v1[i].second.first.second<<"\t"
            <<ct[i]<<"\t"<<tat[i]<<"\t"<<wt[i]<<endl;
    }

    double avg_tat = accumulate(tat.begin(), tat.end(), 0.0) / n;
    double avg_wt = accumulate(wt.begin(), wt.end(), 0.0) / n;

    cout << "\nAverage Turnaround Time: " << avg_tat << endl;
    cout << "Average Waiting Time: " << avg_wt << endl;


    return 0;
}
