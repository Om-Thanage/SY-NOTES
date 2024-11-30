import java.util.*;

public class Median {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter the number of elements in the first array:");
        int n1 = s1.nextInt();
        int[] arr1 = new int[n1];
        System.out.println("Enter elements of the first array:");
        for (int i = 0; i < n1; i++) {
            arr1[i] = s1.nextInt();
        }
        System.out.println("Enter the number of elements in the second array:");
        int n2 = s1.nextInt();
        int[] arr2 = new int[n2];
        System.out.println("Enter elements of the second array:");
        for (int i = 0; i < n2; i++) {
            arr2[i] = s1.nextInt();
        }
        int[] arr3 = new int[n1 + n2];
        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                arr3[k++] = arr1[i++];
            } else {
                arr3[k++] = arr2[j++];
            }
        }
        while (i < n1) {
            arr3[k++] = arr1[i++];
        }
        while (j < n2) {
            arr3[k++] = arr2[j++];
        }
        int totalLen = n1 + n2;
        double median = arr3[totalLen / 2];
        if(totalLen%2 == 0){
            median = arr3[(totalLen/2) - 1];
        }

        System.out.println("Median: " + median);
        s1.close();
    }
}
