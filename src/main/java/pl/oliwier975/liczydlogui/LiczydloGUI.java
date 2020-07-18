package pl.oliwier975.liczydlogui;

import pl.oliwier975.liczydlogui.operations.cli.AdditionCLI;
import pl.oliwier975.liczydlogui.operations.cli.DivisionCLI;
import pl.oliwier975.liczydlogui.operations.cli.MultiplicationCLI;
import pl.oliwier975.liczydlogui.operations.cli.PowerCLI;
import pl.oliwier975.liczydlogui.operations.gui.DivisionGUI;
import pl.oliwier975.liczydlogui.operations.gui.MultiplicationGUI;
import pl.oliwier975.liczydlogui.operations.gui.PowerGUI;
import pl.oliwier975.liczydlogui.operations.gui.AdditionGUI;

import javax.swing.*;
import java.awt.*;

public class LiczydloGUI {
    private static final String VERSION = "0.4.1";

    public static void main(String[] args) {
        System.out.println("LiczydłoGUI " + VERSION);
        if (args.length > 0) {
            System.out.println("Używanie interfejsu konsolowego.");
            if (args[0].equals("--cli") | args[0].equals("-c")) {
                if (args.length > 1) {
                    if (args[1].isEmpty()) System.out.println("Wpisz --cli --help, by wyświetlić stronę pomocy.");
                    else if (args[1].equals("--help") | args[1].equals("-h")) {
                        System.out.println("Dostępne argumenty:");
                        System.out.println("dodawanie");
                        System.out.println("↳ Dodaje wiele liczb.");
                        System.out.println("mnozenie");
                        System.out.println("↳ Dużo mnoży.");
                        System.out.println("dzielenie");
                        System.out.println("↳ Dzieli w dół.");
                        System.out.println("potegowanie");
                        System.out.println("↳ Potęguje.");
                        System.out.println("--help");
                        System.out.println("↳ Wyświetla tę wiadomość.");
                    }
                    else if (args[1].equals("dodawanie") | args[1].equals("-a")) new AdditionCLI();
                    else if (args[1].equals("mnozenie") | args[1].equals("-m")) new MultiplicationCLI();
                    else if (args[1].equals("dzielenie") | args[1].equals("-d")) new DivisionCLI();
                    else if (args[1].equals("potegowanie") | args[1].equals("-p")) new PowerCLI();
                    else System.out.println("Niepoprawny argument. Wpisz --cli --help, by wyświetlić stronę pomocy.");
                } else System.out.println("Wpisz --cli --help, by wyświetlić stronę pomocy.");
            } else System.out.println("Niepoprawny argument. Wpisz --cli --help, by wyświetlić stronę pomocy.");
        } else {
            System.out.println("Możesz użyć argumentu --cli, by użyć interfejsu konsolowego.");
            JFrame frame = new JFrame("LiczydłoGUI");
            frame.setSize(590, 110);
            frame.setLayout(null);
            frame.setVisible(true);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            System.out.println("Otworzono główne okno.");
            JButton addition = new JButton("Dodawanie");
            addition.setBounds(20, 20, 120, 32);
            addition.addActionListener(actionEvent -> new AdditionGUI());
            JButton multiplication = new JButton("Mnożenie");
            multiplication.setBounds(160, 20, 120, 32);
            multiplication.addActionListener(actionEvent -> new MultiplicationGUI());
            JButton division = new JButton("Dzielenie");
            division.setBounds(300, 20, 120, 32);
            division.addActionListener(actionEvent -> new DivisionGUI());
            JButton power = new JButton("Potęgowanie");
            power.setBounds(440,20,130,32);
            Component[] frameElements = {addition, multiplication, division, power};
            for (Component frameElement : frameElements) frame.add(frameElement);
            power.addActionListener(actionEvent -> new PowerGUI());
        }
    }
}
