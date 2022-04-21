import exceptions.NotExistingEquationException;
import utils.PrintingMethods;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static utils.PrintingMethods.*;

public class Main {
    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("Choose operating mode: " +
                        "\n '1' - Solving nonlinear equation," +
                        "\n '2' - Solving systems of nonlinear equations,");
                printingChooseElementString();
                Scanner scanner = new Scanner(System.in);
                int operatingMode = scanner.nextInt();
                if (operatingMode == 1) {
                    solvingEquation();
                }
                if (operatingMode == 2) {
                    solvingEquationSystem();
                }
            } catch (InputMismatchException inputMismatchException) {
                System.err.println("\nERROR! Operation mode must be an Integer!");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped!");
                System.exit(1);
            } catch (NotExistingEquationException e) {
                System.err.println("\nERROR! Can't find this equation!\n");
                continue;
            }
        }
    }
}