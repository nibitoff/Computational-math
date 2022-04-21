package utils;

import exceptions.NotExistingEquationException;
import numericalMethods.Newton;

import java.util.InputMismatchException;
import java.util.Scanner;

import static numericalMethods.Bisection.bisectionMethod;
import static numericalMethods.Chord.chordMethod;
import static numericalMethods.Newton.newtonMethod;
import static utils.EquationStorage.*;

public class PrintingMethods {
    public static void printingChooseElementString() {
        System.out.print("Enter the value: ");
    }

    public static void solvingEquation() {
        while (true) {
            try {
                printEquations();
                printingChooseElementString();
                Scanner scanner = new Scanner(System.in);
                int equationNumber = scanner.nextInt();
                if (equationNumber > 5 || equationNumber <= 0) {
                    System.err.println("Error! Can't find this equation!");
                    continue;
                }
                System.out.println("Enter the beginning of the interval:");
                printingChooseElementString();
                double a = scanner.nextDouble();
                System.out.println("Enter the end of the interval:");
                printingChooseElementString();
                double b = scanner.nextDouble();
                if (b < a) {
                    System.err.println("The end of the interval must be greater than the beginning!");
                    continue;
                }
                double eps = enterAccuracy();
                double answerBisection = bisectionMethod(a, b, eps, equationNumber);
                System.out.print("\nBisection solution result: ");
                System.out.println(answerBisection);
                double answerChord = chordMethod(a, b, eps, equationNumber);
                System.out.print("Chord solution result: ");
                System.out.println(answerChord);
                printDifference(answerBisection, answerChord);
                break;
            } catch (InputMismatchException | NotExistingEquationException e) {
                System.err.println("ERROR! Operation mode must be '1' or '2'!");
            }
        }
    }

    public static void solvingEquationSystem() throws NotExistingEquationException {
        while (true) {
            printEquationSystems();
            printingChooseElementString();
            Scanner scanner = new Scanner(System.in);
            int equationSystemNumber = scanner.nextInt();
            if (equationSystemNumber > 3 || equationSystemNumber <= 0) {
                System.err.println("Error! Can't find this equation system!");
                continue;
            }
            System.out.println("Enter the initial approximation for x:");
            printingChooseElementString();
            double x = scanner.nextDouble();
            System.out.println("Enter the initial approximation for y:");
            printingChooseElementString();
            double y = scanner.nextDouble();
            double eps = enterAccuracy();
            double[] answers = newtonMethod(equationSystemNumber, x, y, eps);
            System.out.println("\nNewton method solution result: ");
            System.out.print("x: ");
            System.out.println(answers[0]);
            System.out.print("y: ");
            System.out.println(answers[1]);
            System.out.println("Number of iterations: " + answers[2] + "\n");
            break;
        }
    }

    public static void printDifference(double answer1, double answer2) {
        System.out.print("The difference between two methods: ");
        System.out.print(Math.abs(answer2 - answer1));
        System.out.println("\n");
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
}
