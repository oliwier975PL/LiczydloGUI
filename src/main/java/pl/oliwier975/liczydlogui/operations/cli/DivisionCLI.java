package pl.oliwier975.liczydlogui.operations.cli;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisionCLI {
    public DivisionCLI() {
        try {
            Scanner dividendQuestion = new Scanner(System.in);
            System.out.print("Jaką liczbę chcesz dzielić: ");
            float dividend = dividendQuestion.nextFloat();

            Scanner dividerQuestion = new Scanner(System.in);
            System.out.print("Jaka jest liczba, od której chcesz dzielić: ");
            int divider = dividerQuestion.nextInt();

            System.out.println("-----------");
            for (int dummy = divider; dummy >= 1; --dummy) {
                float result = dividend / dummy;
                System.out.println(dividend + " / " + dummy + " = " + result);
            }
            System.out.println("-----------");
        } catch (InputMismatchException e) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            System.out.println("Wprowadzono nieprawidłową liczbę!");
        }
    }
}
