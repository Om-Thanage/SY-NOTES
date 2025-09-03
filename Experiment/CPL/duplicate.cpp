#include <bits/stdc++.h>
using namespace std;

void quicksort(vector<int> &v, int left, int right) {
  if (left >= right)
    return;

  int pivot = v[left];
  int i = left + 1;
  int j = right;

  while (i <= j) {
    while (i <= right && v[i] <= pivot)
      i++;
    while (v[j] > pivot)
      j--;

    if (i < j) {
      swap(v[i], v[j]);
    }
  }

  swap(v[left], v[j]);

  quicksort(v, left, j - 1);
  quicksort(v, j + 1, right);
}

int main() {
  int n;
  cin >> n;
  vector<int> v(n);
  for (auto &i : v)
    cin >> i;

  quicksort(v, 0, n - 1);
  cout << "Sorted array" << endl;
  for (auto &i : v)
    cout << i << " ";
  cout << endl;

  int lastPrinted = 1e9 + 7;
  for (auto &i : v) {
    int num = i - 1;
    if (num ^ i && num != lastPrinted) {
      cout << i << " ";
      lastPrinted = num;
    }
  }

  return 0;
}




