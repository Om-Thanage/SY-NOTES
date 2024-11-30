// import java.util.Scanner;

// public class PlayerInfo{
//     public static void main(String[] args){
//         Scanner s1 = new Scanner(System.in);
//         System.out.print("Enter the number of players: ");
//         int n = s1.nextInt();
        
//         int[][] runs = new int[n][];
//         for (int i = 0; i < n; i++){
//             System.out.print("Enter the number of matches played by player "+(i + 1)+": ");
//             int matches = s1.nextInt();
//             runs[i] = new int[matches];

//             System.out.println("Enter the runs scored in each match:");
//             for (int j = 0; j < matches; j++) {
//                 System.out.print("Match "+(j + 1)+": ");
//                 runs[i][j] = s1.nextInt();
//             }
//         }
//         for (int i = 0; i < n; i++) {
//             int total = 0;
//             System.out.print("\nPlayer "+(i + 1)+" runs: ");
//             for (int j = 0; j < runs[i].length; j++) {
//                 System.out.print(runs[i][j]+" ");
//                 total += runs[i][j];
//             }

//             double average = (runs[i].length > 0)?(double)total/runs[i].length:0.0;
//             System.out.println("\nBatting Average: " + average);
//             System.out.println();
//         }
//         s1.close();
//     }
// }
import java.util.*;

class Largestsum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        System.out.println("Please enter the array here: ");
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int max=0,max_end=0;
        for (int i=0;i<n;i++){
            max_end += arr[i];
            if (max_end > max){
                max = max_end;
            }
            if (max_end <0 ){
                max_end=0;
            }
        }
        System.out.println("The sum of contiguous subarray is " + max);
        sc.close();
    }
}



