import java.util.Scanner;

public class AddMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows for both matrices:");
        int rows = sc.nextInt();
        System.out.println("Enter the number of columns for both matrices:");
        int cols = sc.nextInt();

        int[][] mat1 = new int[rows][cols];
        int[][] mat2 = new int[rows][cols];

        System.out.println("Enter the values of matrix 1:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Element [" + ( i + 1 ) + "][" + (j + 1 ) + "]: ");
                mat1[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the values of matrix 2:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Element [" + (i +1) + "][" + (j+1) + "]: ");
                mat2[i][j] = sc.nextInt();
            }
        }

        int[][] result = new int[rows][cols];
        System.out.println("The added matrix is:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = mat1[i][j] + mat2[i][j];
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        int [][] mul =  new int [rows][cols];
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                int sum = 0;
                for(int k  = 0; k<rows; k++){
                    sum += mat1[i][k] * mat2[k][j];
                }
                mul[i][j] = sum;

            }
        }

        System.out.println("Multiplication Matrix");
        for(int i = 0; i<rows; i++){
            for(int j  = 0; j<cols;  j++){
                System.out.print(mul[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
