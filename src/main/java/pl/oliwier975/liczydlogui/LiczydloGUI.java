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

public final class LiczydloGUI {
    private static final String VERSION = "0.4.1";
    private static final String HELP = "Wpisz --help, by wyświetlić stronę pomocy.";
    private static final String BAD_ARGUMENT = "Niepoprawny argument. " + HELP;

    public static void main(String[] args) {
        System.out.println("LiczydłoGUI " + VERSION);
        if (args.length > 0) {
            if (args[0].isEmpty()) System.out.println(HELP);
            else {
                switch (args[0].toLowerCase()) {
                    case "--help":
                    case "-h":
                        System.out.println("Dostępne argumenty:");
                        Util.commandArgument("-a, --dodawanie", "Dodaje wiele liczb.");
                        Util.commandArgument("-m, --mnozenie", "Dużo mnoży.");
                        Util.commandArgument("-d, --dzielenie", "Dzieli w dół.");
                        Util.commandArgument("-p, --potegowanie", "Potęguje.");
                        Util.commandArgument("-h, --help", "Wyświetla tę wiadomość.");
                        break;
                    case "--dodawanie":
                    case "-a":
                        new AdditionCLI();
                        break;
                    case "--mnozenie":
                    case "-m":
                        new MultiplicationCLI();
                        break;
                    case "--dzielenie":
                    case "-d":
                        new DivisionCLI();
                        break;
                    case "--potegowanie":
                    case "-p":
                        new PowerCLI();
                        break;
                    default:
                        System.out.println(BAD_ARGUMENT);
                        break;
                }
            }
        } else {
            System.out.println(HELP);

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
            power.setBounds(440, 20, 130, 32);
            power.addActionListener(actionEvent -> new PowerGUI());

            Component[] frameElements = {addition, multiplication, division, power};
            for (Component frameElement : frameElements) frame.add(frameElement);
        }
    }
}
