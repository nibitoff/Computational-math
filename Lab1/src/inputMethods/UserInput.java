package inputMethods;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    boolean checkFlag = true;
    double[][]coeffs;
    int matrixSize;
    int rowsSize;
    int columnsSize;
    public double[][] userInput() {
        try {
            System.out.println("# Enter the size of the matrix: ");
            Scanner scannerSize = new Scanner(System.in);
            matrixSize = scannerSize.nextInt();
            rowsSize = matrixSize;
            columnsSize = matrixSize + 1;
            coeffs = new double[rowsSize][columnsSize];
            if (matrixSize > 20 || matrixSize <= 0) {
                System.out.println("# ERROR! Matrix's size must be in range (0;20]!");
                checkFlag = false;
            }
            if (checkFlag) {
                System.out.println("# Enter the coefficients of the matrix separated by space: ");
                Scanner scannerMatrix = new Scanner(System.in);
                try {
                    for (int i = 0; i < rowsSize; i++) {
                        for (int j = 0; j < columnsSize; j++) {
                            coeffs[i][j] = scannerMatrix.nextDouble();
                        }
                    }
                } catch (InputMismatchException inputMismatchException) {
                    System.out.println("# ERROR! Check entered coefficients!");
                }
                System.out.println("# Entered matrix:");
                for (int i = 0; i < rowsSize; i++) {
                    for (int j = 0; j < columnsSize; j++) {
                        System.out.print(coeffs[i][j]);
                        System.out.print(" ");
                    }
                    System.out.println("");
                }
                System.out.println("");

                return coeffs;
            }
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("\n# ERROR! Matrix's size must be an integer!");
            checkFlag = false;
        }
        return null;
    }

}

