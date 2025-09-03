#include <bits/stdc++.h>
using namespace std;

void firstFit(vector<int> partition, vector<int> process) {
    int n = process.size();
    int m = partition.size();
    vector<int> alloc(n, -1);
    
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (partition[j] >= process[i]) {
                alloc[i] = j;
                partition[j] = -1;
                break;
            }
        }
    }

    cout << "First Fit Allocation:\nProcess No.\tProcess Size\tPartition No.\n";
    for (int i = 0; i < n; i++) {
        cout << i + 1 << "\t\t" << process[i] << "\t\t";
        if (alloc[i] != -1) cout << alloc[i] + 1;
        else cout << "Not Allocated";
        cout << endl;
    }
}

void bestFit(vector<int> partition, vector<int> process) {
    int n = process.size();
    int m = partition.size();
    vector<int> alloc(n, -1);
    
    for (int i = 0; i < n; i++) {
        int bestIdx = -1;
        for (int j = 0; j < m; j++) {
            if (partition[j] >= process[i]) {
                if (bestIdx == -1 || partition[j] < partition[bestIdx]) {
                    bestIdx = j;
                }
            }
        }
        if (bestIdx != -1) {
            alloc[i] = bestIdx;
            partition[bestIdx] = -1;
        }
    }

    cout << "\nBest Fit Allocation:\nProcess No.\tProcess Size\tPartition No.\n";
    for (int i = 0; i < n; i++) {
        cout << i + 1 << "\t\t" << process[i] << "\t\t";
        if (alloc[i] != -1) cout << alloc[i] + 1;
        else cout << "Not Allocated";
        cout << endl;
    }
}

void worstFit(vector<int> partition, vector<int> process) {
    int n = process.size();
    int m = partition.size();
    vector<int> alloc(n, -1);
    
    for (int i = 0; i < n; i++) {
        int worstIdx = -1;
        for (int j = 0; j < m; j++) {
            if (partition[j] >= process[i]) {
                if (worstIdx == -1 || partition[j] > partition[worstIdx]) {
                    worstIdx = j;
                }
            }
        }
        if (worstIdx != -1) {
            alloc[i] = worstIdx;
            partition[worstIdx] = -1;
        }
    }

    cout << "\nWorst Fit Allocation:\nProcess No.\tProcess Size\tPartition No.\n";
    for (int i = 0; i < n; i++) {
        cout << i + 1 << "\t\t" << process[i] << "\t\t";
        if (alloc[i] != -1) cout << alloc[i] + 1;
        else cout << "Not Allocated";
        cout << endl;
    }
}

int main() {
    cout << "Enter the number of partitions:" << endl;
    int n; cin >> n;
    cout << "Enter the number of processes:" << endl;
    int m; cin >> m;
    
    cout << "Enter the size of each partition:" << endl;
    vector<int> partition(n);
    for (int i = 0; i < n; i++) cin >> partition[i];
    
    cout << "Enter the size of each process:" << endl;
    vector<int> process(m);
    for (int i = 0; i < m; i++) cin >> process[i];   
    
    firstFit(partition, process);
    bestFit(partition, process);
    worstFit(partition, process);
    
    return 0;
}
