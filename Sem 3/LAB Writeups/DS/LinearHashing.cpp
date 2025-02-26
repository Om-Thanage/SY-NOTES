#include <bits/stdc++.h>
using namespace std;
#define int long long
#define endl "\n"

const int MOD = 1e9 + 7;
const int INF = LLONG_MAX >> 1;

signed main(){
       
    cout<<"Enter the size of the hash table: ";
    int n; cin>>n;
    if (n <= 0) {
        cout << "Hash table size must be greater than 0!" << endl;
        return 0;
    }
    vector<int> hash(n, -1);
    cout<<"Enter the number of elements to be inserted: ";
    int m; cin>>m;
    if (m > n) {
        cout << "Number of elements exceeds the size of the hash table!" << endl;
        return 0;
    }
    cout<<"Enter the elements: ";
    for(int i=0; i<m; i++){
        int x; cin>>x;
        int index = x % n;
        while(hash[index] != -1){
            index = (index + 1) % n;
        }
        hash[index] = x;
    }
    cout<<"Hash Table: ";
    for(int i=0; i<n; i++){
        cout<<hash[i]<<" ";
    }
    return 0;
}