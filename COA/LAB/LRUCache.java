import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LRUCache {
    public static boolean contains(List<int[]> arr, int n) {
        for (int[] element : arr) {
            if (element[0] == n) {
                return true;
            }
        }
        return false;
    }

    public static int getInRank(List<int[]> arr, int n) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i)[1] == n) {
                return i;
            }
        }
        return -1;
    }

    public static int getInEle(List<int[]> arr, int n) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i)[0] == n) {
                return i;
            }
        }
        return -1;
    }

    public static int push(List<int[]> arr, int n) {
        if (!contains(arr, n)) {
            int x = getInRank(arr, 3);
            arr.get(x)[0] = n;
            arr.get(x)[1] = 0;
            for (int i = 0; i < arr.size(); i++) {
                if (i != x) {
                    arr.get(i)[1]++;
                }
            }
            return 0;
        } else {
            int x = getInEle(arr, n);
            int l = arr.get(x)[1];
            arr.get(x)[1] = 0;
            for (int i = 0; i < arr.size(); i++) {
                if (i != x && arr.get(i)[1] <= l) {
                    arr.get(i)[1]++;
                }
            }
            return 1;
        }
    }

    public static void main(String[] args) {
        List<int[]> memory = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            memory.add(new int[]{-1, 3 - i});
        }
        int h = 0;
        int r = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu");
            System.out.println("1. Push element to cache");
            System.out.println("2. Display cache");
            System.out.println("3. Print Hit Rate and Miss Ratio");
            System.out.println("4. Exit");
            System.out.print("\nEnter Choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter element to be pushed to cache: ");
                    int n = scanner.nextInt();
                    h += push(memory, n);
                    r++;
                    System.out.println(n + " pushed to cache");
                    break;
                case 2:
                    System.out.println("\nPF Age");
                    for (int[] element : memory) {
                        System.out.println(element[0] + " " + element[1]);
                    }
                    break;
                case 3:
                    if (r == 0) {
                        System.out.println("\nEnter an element first");
                        break;
                    }
                    double hr = ((double) h / r) * 100;
                    double mr = 100 - hr;
                    System.out.println("\nNumber of Hits: " + h);
                    System.out.println("Number of References: " + r);
                    System.out.println("\nHit Rate: " + hr + "%");
                    System.out.println("Miss Ratio: " + mr + "%");
                    break;
                case 4:
                    System.out.println("Exiting Program \n");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }
}
