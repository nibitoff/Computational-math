package utils;

public class Gauss {
    static int substitution = 1;
    static double determinant = 1;
        public static double[][] calculateGauss(double[][] matrix, double[] answers) {
            double[][] newMatrix = addColumnToMatrix(matrix, answers);
            for (int i = 0; i < matrix.length; i++) {
                newMatrix = swapColumns(newMatrix, matrix.length, i);
                newMatrix = addingZeroes(newMatrix, matrix.length, i);
            }
            determinant = calculateDeterminant(newMatrix, matrix.length) * substitution;

            return newMatrix;
        }
        private static double[][] addColumnToMatrix(double[][] matrix, double[] answers) {
             double[][] resultMatrix = new double[matrix.length][matrix.length + 1];
             for (int i = 0; i < matrix.length; i++) {
                  for (int j = 0; j < matrix.length; j++) {
                       resultMatrix[i][j] = matrix[i][j];
                 }
            }
             for (int i = 0; i < matrix.length; i++) {
                  resultMatrix[i][matrix.length] = answers[i];
             }
             return resultMatrix;
        }

        public static double[] getUnknownColumn(double[][] matrix, double[] results) {
            double[][] triangleMatrix = calculateGauss(matrix, results);
            double[] unknownColumn = new double[results.length];
            for (int i = triangleMatrix.length - 1; i >= 0; i--) {
                double sum = 0;
                double element = triangleMatrix[i][triangleMatrix.length];
                 if (!checkNullRow(triangleMatrix[i]) && triangleMatrix[i][i] != 0) {
                     for (int j = 0; j < triangleMatrix.length; j++) {
                      if (j != i) {
                          sum += unknownColumn[j] * triangleMatrix[i][j];
                      }
                     }
                  unknownColumn[i] = (element - sum) / triangleMatrix[i][i];
             }
        }
        return unknownColumn;
    }
        private static double[][] swapColumns(double[][] matrix, int size, int stringNum){
            double[][] resultMatrix = matrix;
            double[] newString;
            double matrixElement = matrix[stringNum][stringNum];
            if (matrixElement == 0){
                while (stringNum != size - 1 && matrixElement == 0){
                    newString = matrix[stringNum];
                    matrix[stringNum] = matrix[stringNum + 1];
                    matrix[stringNum + 1] =newString;
                    matrixElement =resultMatrix[stringNum][stringNum];
                    stringNum = stringNum + 1;
                    substitution = substitution * (-1);
                }
            }
            return resultMatrix;
        }

        private static double[][] addingZeroes(double[][] matrix, int size, int stringNum){
            double[][] resultMatrix = matrix;
            double coeff;
            for (int i = stringNum + 1; i < size; i++){
                if (matrix[stringNum][stringNum] != 0){
                    coeff = matrix[i][stringNum]/matrix[stringNum][stringNum] * (-1);
                    for (int j = 0; j < size + 1; j++){
                        resultMatrix[i][j] = resultMatrix[i][j] + matrix[stringNum][j] * coeff;
                    }
                }
                else {
                    break;
                }
            }
            return resultMatrix;
        }

        private static double calculateDeterminant(double[][] matrix, int size){
            double determinant = 1;
            for (int i = 0; i < size; i++){
                determinant = determinant * matrix[i][i];
            }
            return determinant;
        }
    private static boolean checkNullRow(double[] row) {
        for (double element : row) {
            if (element != 0) return false;
        }
        return true;
    }

    }




