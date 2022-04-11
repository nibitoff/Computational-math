package inputMethods;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RandomInput {
    public double[][] getMatrix() {
        int matrixSize = 0;
        try {
            System.out.println("# Enter the size of the matrix: ");
            Scanner scannerSize = new Scanner(System.in);
            matrixSize = scannerSize.nextInt();
            if (matrixSize > 20 || matrixSize <= 0) {
                System.out.println("# ERROR! Matrix's size must be in range (0;20]!");
                return null;
            }
            double [][] matrix = new double[matrixSize][matrixSize+1];
            for (int i = 0; i < matrixSize; i++){
                for (int j = 0; j < matrixSize + 1; j++){
                    matrix[i][j] = Math.random()*10;
                }
            }
            System.out.println("# Entered matrix:");
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize + 1; j++) {
                    System.out.print(matrix[i][j]);
                    System.out.print(" ");
                }
                System.out.println("");
            }
            System.out.println("");

            return matrix;
        }catch (InputMismatchException inputMismatchException) {
            System.out.println("\n# ERROR! Matrix's size must be an integer!");
        }
        return null;
    }
}
