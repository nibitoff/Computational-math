package utils;

import exceptions.BordersException;
import exceptions.IrremovableGapException;
import exceptions.NotDefinedFunctionException;
import exceptions.NotExistingIntegralException;
import mathMethods.TrapezoidMethod;
import utils.integrals.IntegralsStorage;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleUI {
    public static void startApp() throws BordersException, NotExistingIntegralException, IrremovableGapException, NotDefinedFunctionException {
        while (true) {
            try {
                IntegralsStorage.printIntegrals();
                printingChooseElementString();
                Scanner scanner = new Scanner(System.in);
                int integral = scanner.nextInt();
                if (integral > 5 || integral <= 0){
                    throw new NotExistingIntegralException();
                }
                double[] borders = enterBorders();
                double eps = enterAccuracy();
                printAnswer(TrapezoidMethod.trapezoidMethod(integral, borders, eps));
                break;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("ERROR! The value must be an Integer!");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped!");
                System.exit(1);
            }
        }
    }

    public static void printingChooseElementString() {
        System.out.print("Enter the value: ");
    }

    private static double[] enterBorders() throws BordersException {
        while (true) {
            double[] borders = new double[2];
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter integration borders:");
            printingChooseElementString();
            borders[0] = scanner.nextDouble();
            printingChooseElementString();
            borders[1] = scanner.nextDouble();
            if (borders[0] >= borders[1]) {
                throw new BordersException();
            }
            return borders;
        }
    }
    public static double enterAccuracy() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the accuracy:");
                printingChooseElementString();
                double eps = scanner.nextDouble();
                if (eps >= 1.0 || eps <= 0.0) {
                    System.err.println("\nError! The accuracy must be between '0' and '1'!\n");
                    continue;
                }
                return eps;
            } catch (InputMismatchException e) {
                System.err.println("\nError! The accuracy must be between '0' and '1'!\n");
            }
        }
    }

    private static void printAnswer(double[] answer){
        System.out.println("\nIntegral value = " + answer[0]);
        //System.out.println("Error <= " + answer[1]);
        System.out.println("Amount of segments needed for this accuracy = " + (int) answer[1]);
    }
}
