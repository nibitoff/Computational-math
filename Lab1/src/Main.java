import inputMethods.FileInput;
import inputMethods.RandomInput;
import inputMethods.UserInput;
import calculations.MethodGauss;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double[][] matrix = new double[0][0];
        MethodGauss methodGauss = new MethodGauss();
        boolean checkInput = false;
        while (true) {
            try {
                System.out.println("# Choose method for entering data for the matrix: " +
                        "\n# '1' - User's input," +
                        "\n# '2' - Input from the file," +
                        "\n# '3' - Generation of the random matrix;");
                Scanner scanner = new Scanner(System.in);
                int inputMode = scanner.nextInt();
                if (inputMode == 1) {
                    UserInput userInput = new UserInput();
                    matrix = userInput.userInput();
                    if (matrix != null) {
                        checkInput = true;
                    }
                }
                if (inputMode == 2) {
                    FileInput fileInput = new FileInput();
                    matrix = fileInput.getMatrix();
                    if (matrix != null) {
                        checkInput = true;
                    }
                }
                if (inputMode == 3) {
                    RandomInput randomInput = new RandomInput();
                    matrix = randomInput.getMatrix();
                    if (matrix != null) {
                        checkInput = true;
                    }
                }

                if (checkInput) {
                    double[][] resultMatrix = methodGauss.calculateGauss(matrix, matrix[0].length - 1);
                    int matrixSize = matrix[0].length - 1;
                    System.out.println("# Determinant equals: " + methodGauss.getDeterminant());
                    System.out.println("# Triangular matrix:");
                    for (int i = 0; i < matrixSize; i++) {
                        for (int j = 0; j < matrixSize + 1; j++) {
                            System.out.print(resultMatrix[i][j]);
                            System.out.print(" ");
                        }
                        System.out.println("");
                    }
                    System.out.println("");

                    if (methodGauss.getDeterminant() != 0) {
                        System.out.println("# Equation roots:");
                        double[] root = methodGauss.getRoots(resultMatrix, matrixSize);
                        for (int i = 0; i < matrixSize; i++) {
                            System.out.println("X_" + (i + 1) + " = " + root[i]);
                        }
                        System.out.println("# Discrepancies:");
                        for (int i = 0; i < matrixSize; i++) {
                            System.out.println("Dis_" + (i + 1) + " = " +
                                    methodGauss.getDiscrepancies(resultMatrix, matrixSize, root)[i]);
                        }
                    } else {
                        System.out.println("# There are no roots!");
                    }
                }

            } catch (InputMismatchException inputMismatchException) {
                System.out.println("# ERROR! Method value must be '1', '2', '3'!");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("# Program was stopped!");
                System.exit(1);
            } catch (NullPointerException nullPointerException){
                System.out.println("# ERROR! Matrix is null!");
            }

        }
    }

}