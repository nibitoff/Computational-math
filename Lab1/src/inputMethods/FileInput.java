package inputMethods;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInput {
    public double[][] getMatrix(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("# Enter path to the file: ");
        String pathToFile = scanner.nextLine();
        File file = new File(pathToFile);

        if (!file.exists()){
            System.out.println("# Error! File is not existing!");
            return null;
        }

        if (!file.isFile() && !file.isDirectory()){
            System.out.println("# Error! Something wrong with the file!");
            return null;
        }

        if (!file.canRead()){
            System.out.println("# Error! Problems with reading this file!");
            return null;
        }

        try{
            int matrixSize = 0;
            Scanner scanFile = new Scanner(file);
            if (scanFile.hasNextLine()){
                matrixSize = Integer.parseInt(scanFile.nextLine());
            }
            else {
                System.out.println("# Error! Can't find size of the matrix in the first line!");
                return null;
            }

            double[][] matrix = new double[matrixSize][matrixSize+1];
            for (int i = 0; i < matrixSize; i++) {
                if (scanFile.hasNextLine()) {
                    String[] fileLine = scanFile.nextLine().trim().split(" ");
                    if (fileLine.length != matrixSize + 1) {
                        System.out.println("# Error! Check the amount of symbols in line!");
                        return null;
                    }
                    for (int j = 0; j < matrixSize + 1; j++) {
                        matrix[i][j] = Double.parseDouble(fileLine[j]);
                    }
                }
            }
            return matrix;

        }catch (FileNotFoundException e){
            System.out.println("# Error! Can't find the file!");

        }
        return null;
    }
}
