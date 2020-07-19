package pl.oliwier975.liczydlogui.operations.cli;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AdditionCLI {
    public AdditionCLI() {
        try {
            Scanner component1Question = new Scanner(System.in);
            System.out.print("Pierwszy składnik dodawania: ");
            float component1 = component1Question.nextFloat();

            Scanner component2Question = new Scanner(System.in);
            System.out.print("Drugi składnik dodawania: ");
            float component2 = component2Question.nextFloat();

            Scanner howManyTimesQuestion = new Scanner(System.in);
            System.out.print("Ile razy chcesz dodawać: ");
            int howManyTimes = howManyTimesQuestion.nextInt();

            System.out.println("-----------");
            for (int dummy = 1; dummy <= howManyTimes; ++dummy) {
                float result = component1 + component2;
                System.out.println(component1 + " + " + component2 + " = " + result);
                component1 = component1 + component2;
            }
            System.out.println("-----------");
        } catch (InputMismatchException e) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            System.out.println("Wprowadzono nieprawidłową liczbę!");
        }
    }
}
