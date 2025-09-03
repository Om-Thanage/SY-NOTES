#include <bits/stdc++.h>
using namespace std;

int main(){
    cout<<"Enter the number of processes: ";
    int n; cin>>n;

    vector<pair<pair<int, int>, string>> v1(n);

    cout<<"Enter Process ID, Arrival Time, Burst Time for each process:\n";
    for (int i = 0; i < n; i++){
        string id;
        int at, bt;
        cin>>id>>at>>bt;
        v1[i] = {{at, bt}, id};
    }

    stable_sort(v1.begin(), v1.end(), [](const auto &a, const auto &b){
        return a.first.first < b.first.first;
    });

    vector<int> ct(n), tat(n), wt(n);
    int temp = 0;

    for (int i = 0; i< n; i++){
        int at = v1[i].first.first;
        int bt = v1[i].first.second;

        temp = max(temp, at) + bt;
        ct[i] = temp;
        tat[i] = ct[i] - at;
        wt[i] = tat[i] - bt;
    }

    cout << "\nProcess\tAT\tBT\tCT\tTAT\tWT\n";
    for (int i = 0; i< n; i++){
        cout<<v1[i].second<<"\t"<<v1[i].first.first<<"\t"<<v1[i].first.second<<"\t"<<ct[i]<<"\t"<<tat[i]<<"\t"<<wt[i]<<endl;
    }

    return 0;
}