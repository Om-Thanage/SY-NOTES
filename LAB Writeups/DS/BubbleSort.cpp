#include <bits/stdc++.h>
using namespace std;
#define int long long
#define endl "\n"

const int MOD = 1e9 + 7;
const int INF = LLONG_MAX >> 1;

signed main(){
    cout << "Enter the number of elements: ";
    int n; 
    cin >> n;
    vector<int> a(n);
    
    cout << "Enter the elements:\n";
    for(int i = 0; i < n; i++) {
        cin >> a[i];
    }
    
    for(int i = 0; i < n - 1; i++) {
        for(int j = 0; j < n - 1 - i; j++) {
            if(a[j] > a[j + 1]) {
                swap(a[j], a[j + 1]);
            }
        }
    }

    cout << "Sorted elements:\n";
    for(auto i : a) {
        cout << i << " ";
    }
    cout << endl;

    return 0;
}
