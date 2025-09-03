#include <bits/stdc++.h>
using namespace std;

struct Process {
    int pid, arrival, burst, remaining, completion, turnaround, waiting;
};

void srtn(vector<Process>& processes) {
    int time = 0, completed = 0, n = processes.size();
    float avgTAT = 0, avgWT = 0;

    for (auto& p : processes) p.remaining = p.burst;

    while (completed < n) {
        int min_index = -1, min_remaining = INT_MAX;

        for (int i = 0; i < n; i++) {
            if (processes[i].arrival <= time && processes[i].remaining > 0 &&
                processes[i].remaining < min_remaining) {
                min_remaining = processes[i].remaining;
                min_index = i;
            }
        }

        if (min_index != -1) {
            processes[min_index].remaining -= 1;
            time++;

            if (processes[min_index].remaining == 0) {
                completed++;
                processes[min_index].completion = time;
                processes[min_index].turnaround =
                    processes[min_index].completion - processes[min_index].arrival;
                processes[min_index].waiting =
                    processes[min_index].turnaround - processes[min_index].burst;
                avgTAT += processes[min_index].turnaround;
                avgWT += processes[min_index].waiting;
            }
        } else {
            time++;
        }
    }

    avgTAT /= n;
    avgWT /= n;

    cout << "\nShortest Remaining Time Next (SRTN) Scheduling\n";
    cout << "PID\tArrival\tBurst\tCompletion\tTurnaround\tWaiting\n";
    for (auto& p : processes) {
        cout << p.pid << "\t" << p.arrival << "\t" << p.burst << "\t" << p.completion
             << "\t\t" << p.turnaround << "\t\t" << p.waiting << "\n";
    }
    cout << "Average Turnaround Time: " << avgTAT << "\n";
    cout << "Average Waiting Time: " << avgWT << "\n";
}

int main() {
    int n;
    cout << "Enter number of processes: ";
    cin >> n;

    vector<Process> processes(n);
    cout << "Enter Process ID, Arrival Time, and Burst Time:\n";
    for (int i = 0; i < n; i++) {
        cin >> processes[i].pid >> processes[i].arrival >> processes[i].burst;
    }

    sort(processes.begin(), processes.end(), [](Process a, Process b) {
        return a.arrival < b.arrival;
    });

    srtn(processes);
}
