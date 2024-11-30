// import java.util.*;

// public class Matrix {
//     public static void main(String[] args) {
//         Scanner s1 = new Scanner(System.in);
//         System.out.println("Enter the number of rows:");
//         int rows = s1.nextInt();
//         System.out.println("Enter the number of cols:");
//         int cols = s1.nextInt();
//         int[][] matrix1 = new int[rows][cols];


//         System.out.println("Enter Matrix 1");
//         for (int i = 0; i < rows; i++) {
//             for (int j = 0; j < cols; j++) {
//                 matrix1[i][j] = s1.nextInt();
//             }
//         }

//         System.out.println("Enter Matrix 2");
//         int[][] matrix2 = new int[rows][cols];
//         for (int i = 0; i < rows; i++) {
//             for (int j = 0; j < cols; j++) {
//                 matrix2[i][j] = s1.nextInt();
//             }
//         }

//         int [][]mulMatrix = new int[rows][cols];
//         for(int i = 0; i<rows; i++){
//             for(int j = 0; j< cols; j++){
//                 mulMatrix[i][j] += matrix1[i][j]*matrix2[j][i];
//             }

//         }

//         System.out.println("Multiplied Matrix");
//         for(int i = 0; i<rows; i++){
//             for(int j = 0; j<cols; j++){
//                 System.out.println(mulMatrix[i][j] + " ");
//             }
//             System.out.println("\n");
//         }


//         System.out.println("Row-wise:");
//         for (int i = 0; i < rows; i++) {
//             for (int j = 0; j < cols; j++) {
//                 System.out.print(matrix1[i][j] + " ");
//             }
//             System.out.println();
//         }


//         System.out.println("Column-wise:");
//         for (int i = 0; i < cols; i++) {
//             for (int j = 0; j < rows; j++) {
//                 System.out.print(matrix1[j][i] + " ");
//             }
//             System.out.println();
//         }

//         System.out.println("Diagonal elements:");
        
//         for (int line = 0; line < rows + cols - 1; line++) {
//             int startRow = 0;
//             int startCol = 0;
//             if (line < cols) {
//                 startRow = 0;
//                 startCol = line;
//             } else {
//                 startRow = line - cols + 1;
//                 startCol = cols - 1;
//             }
//             while (startRow < rows && startCol >= 0) {
//                 System.out.print(matrix1[startRow][startCol] + " ");
//                 startRow++;
//                 startCol--;
//             }
//             System.out.println(); // Move to the next line after printing a diagonal
//         }

//         s1.close();
//     }
// }


import java.util.*;

public class Matrix {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        
        // Input dimensions for matrix multiplication
        System.out.println("Enter the number of rows for Matrix 1:");
        int rows1 = s1.nextInt();
        System.out.println("Enter the number of columns for Matrix 1 (and rows for Matrix 2):");
        int cols1 = s1.nextInt();
        System.out.println("Enter the number of columns for Matrix 2:");
        int cols2 = s1.nextInt();
        
        // Initialize matrices
        int[][] matrix1 = new int[rows1][cols1];
        int[][] matrix2 = new int[cols1][cols2];  // Notice the rows of matrix2 should be equal to cols1
        int[][] mulMatrix = new int[rows1][cols2]; // Result matrix will be rows1 x cols2
        
        // Input for Matrix 1
        System.out.println("Enter Matrix 1:");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                matrix1[i][j] = s1.nextInt();
            }
        }
        
        // Input for Matrix 2
        System.out.println("Enter Matrix 2:");
        for (int i = 0; i < cols1; i++) {
            for (int j = 0; j < cols2; j++) {
                matrix2[i][j] = s1.nextInt();
            }
        }
        
        // Perform matrix multiplication
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                mulMatrix[i][j] = 0; // Initialize result matrix element
                for (int k = 0; k < cols1; k++) {
                    mulMatrix[i][j] += matrix1[i][k] * matrix2[k][j]; // Dot product logic
                }
            }
        }
        
        // Display the multiplied matrix
        System.out.println("Multiplied Matrix:");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                System.out.print(mulMatrix[i][j] + " ");
            }
            System.out.println();
        }
        
        // Row-wise printing of matrix1
        System.out.println("Row-wise Matrix 1:");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.println();
        }
        
        // Column-wise printing of matrix1
        System.out.println("Column-wise Matrix 1:");
        for (int i = 0; i < cols1; i++) {
            for (int j = 0; j < rows1; j++) {
                System.out.print(matrix1[j][i] + " ");
            }
            System.out.println();
        }
        
        // Printing diagonal elements of matrix1
        System.out.println("Diagonal elements of Matrix 1:");
        for (int line = 0; line < rows1 + cols1 - 1; line++) {
            int startRow, startCol;
            if (line < cols1) {
                startRow = 0;
                startCol = line;
            } else {
                startRow = line - cols1 + 1;
                startCol = cols1 - 1;
            }
            while (startRow < rows1 && startCol >= 0) {
                System.out.print(matrix1[startRow][startCol] + " ");
                startRow++;
                startCol--;
            }
            System.out.println(); // Move to next line after printing a diagonal
        }

        s1.close();
    }
}
