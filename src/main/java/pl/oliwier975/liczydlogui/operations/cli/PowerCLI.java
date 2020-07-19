package pl.oliwier975.liczydlogui.operations.cli;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PowerCLI {
    public PowerCLI() {
        try {
            Scanner numberQuestion = new Scanner(System.in);
            System.out.print("Jaką liczbę chcesz spotęgować: ");
            float number = numberQuestion.nextFloat();

            Scanner howManyTimesQuestion = new Scanner(System.in);
            System.out.print("Ile razy chcesz ją spotęgować: ");
            int howManyTimes = howManyTimesQuestion.nextInt();

            System.out.println("-----------");
            for (int dummy = 1; dummy <= howManyTimes; ++dummy) {
                float result = (float) Math.pow(number, dummy);
                System.out.println(number + " ^ " + dummy + " = " + result);
            }
            System.out.println("-----------");
        } catch (InputMismatchException e) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            System.out.println("Wprowadzono nieprawidłową liczbę!");
        }
    }
}
