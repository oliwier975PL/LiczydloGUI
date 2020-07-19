package pl.oliwier975.liczydlogui.operations.cli;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultiplicationCLI {
    public MultiplicationCLI() {
        try {
            Scanner multiplicandQuestion = new Scanner(System.in);
            System.out.print("Jaką liczbę chcesz wymnożyć: ");
            float multiplicand = multiplicandQuestion.nextFloat();

            Scanner multiplierQuestion = new Scanner(System.in);
            System.out.print("Ile razy: ");
            int multiplier = multiplierQuestion.nextInt();

            System.out.println("-----------");
            for (int dummy = 1; dummy <= multiplier; ++dummy) {
                float result = multiplicand * dummy;
                System.out.println(multiplicand + " * " + dummy + " = " + result);
            }
            System.out.println("-----------");
        } catch (InputMismatchException e) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            System.out.println("Wprowadzono nieprawidłową liczbę!");
        }
    }
}
