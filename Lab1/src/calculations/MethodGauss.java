package calculations;

public class MethodGauss {
    int substitution = 1;
    double determinant = 1;
    public double[][] calculateGauss(double[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            matrix = swapColumns(matrix, size, i);
            matrix = addingZeroes(matrix, size, i);
        }
        determinant = calculateDeterminant(matrix, size) * this.substitution;

        return matrix;
    }

    private double[][] swapColumns(double[][] matrix, int size, int stringNum){
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
                this.substitution =this.substitution * (-1);
            }
        }
        return resultMatrix;
    }

    private double[][] addingZeroes(double[][] matrix, int size, int stringNum){
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

    private double calculateDeterminant(double[][] matrix, int size){
        double determinant = 1;
        for (int i = 0; i < size; i++){
            determinant = determinant * matrix[i][i];
        }
        return determinant;
    }

    public double getDeterminant(){
        return this.determinant;
    }

    public double[] getRoots(double[][] matrix, int size){
        double[] root = new double[size];
        for (int i = 0; i < size; i++) {
            root[size - 1 - i] = utilRoots(matrix, size, root, size-1-i);
        }
        return root;
    }

    private double utilRoots(double[][] matrix, int size, double[] root, int num){
        double result = matrix[num][size];
        for (int j = 0; j < size; j++){
            result = result - matrix[num][j] *root[j];
        }
        result = result/matrix[num][num];
        return result;
    }

    public double[] getDiscrepancies(double[][] matrix, int size, double[] root) {
        double[] discrepancies = new double[size];
        for (int i = 0; i < size; i++) {
            discrepancies[i] = matrix[i][size];
            for (int j = 0; j < size; j++) {
                discrepancies[i] = discrepancies[i] - matrix[i][j] * root[j];
            }
        }
        return discrepancies;
    }




}



