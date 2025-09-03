#include<bits/stdc++.h>
using namespace std;

int main(){
    int n, r;
    cin>>n>>r;
    vector<vector<int>> allocation(n, vector<int>(r, 0));
    vector<vector<int>> Max(n, vector<int>(r, 0));
    vector<vector<int>> Need(n, vector<int>(r, 0));
    vector<vector<int>> Avail(n, vector<int>(r, 0));
    vector<bool> finish(n, false);
    cout<<"Allocation:\n";
    for(auto &i : allocation) for(auto &j : i) cin>>j;
    cout<<"Max\n";
    for(auto &i : Max) for(auto &j : i) cin>>j;
    cout<<"Availability First\n";
    for(auto &i : Avail[0]) cin>>i;

    for(int i = 0; i<n; i++){
        for (int j = 0; j<r; j++){
            Need[i][j] = Max[i][j] - allocation[i][j];
        }
    }
    cout<<"Need:-\n";
    for(auto i:Need){
      for(auto j:i){
        cout<<j<<" ";
      }
      cout<<endl;
    }
    vector<int> safeSequence;
    int count = 0;
    while(count < n){
        bool found = false;
        for(int p = 0; p < n; p++){
            if(!finish[p]){
                int j;
                for(j = 0; j<r; j++)
                    if(Need[p][j] > Avail[0][j])
                        break;

                if(j == r){

                    for(int k = 0; k<r; k++){
                        Avail[0][k] += allocation[p][k];
                    }

                    safeSequence.push_back(p);
                    finish[p] = true;
                    found = true;
                    count++;
                }
            }
        }
        if(!found){
            return 0;
        }
    }

    cout<<"Safe Sequence:-";
    for(int i : safeSequence)
        cout<<i<<" ";
    cout<<endl;

    return 0;
}
