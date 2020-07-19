package pl.oliwier975.liczydlogui.operations.gui;

import pl.oliwier975.liczydlogui.Util;

import javax.swing.*;

import java.awt.*;

import static pl.oliwier975.liczydlogui.Util.isAllowed;

public class PowerGUI {
    public PowerGUI() {
        if (!Util.POWER_OPENED) {
            Util.POWER_OPENED = true;
            System.out.println("Otworzono okno \"Potęgowanie\"!");

            JFrame powerFrame = new JFrame("Potęgowanie");
            powerFrame.setSize(600, 400);
            powerFrame.setLayout(null);
            powerFrame.setVisible(true);
            powerFrame.setResizable(false);
            powerFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

            JTextField number = new JTextField();
            number.setBounds(20,30,100,32);

            JTextField numberQuestion = new JTextField("Jaką liczbę chcesz spotęgować?");
            numberQuestion.setBounds(20,10,250,20);
            numberQuestion.setEditable(false);

            JTextField howManyTimes = new JTextField();
            howManyTimes.setBounds(20,90,100,32);

            JTextField howManyTimesQuestion = new JTextField("Ile razy chcesz ją spotęgować?");
            howManyTimesQuestion.setBounds(20,70,250,20);
            howManyTimesQuestion.setEditable(false);

            JTextArea exit = new JTextArea();
            exit.setEditable(false);

            JScrollPane scroll = new JScrollPane(exit);
            scroll.setVerticalScrollBarPolicy(scroll.VERTICAL_SCROLLBAR_AS_NEEDED);
            scroll.setBounds(300,10,280,300);

            JButton calculate = new JButton("Kalkuluj");
            calculate.setBounds(20,140,120,32);
            calculate.addActionListener(actionEvent -> {
                exit.setText("");
                if (isAllowed(number.getText(),"0",howManyTimes.getText())) {
                    System.out.println("-----------");
                    float numberAsFloat = Float.parseFloat(number.getText());
                    int howManyTimesAsInteger = Integer.parseInt(howManyTimes.getText());
                    for (int dummy = 1; dummy <= howManyTimesAsInteger; ++dummy) {
                        float result = (float) Math.pow(numberAsFloat, dummy);
                        exit.append(numberAsFloat + " ^ " + dummy + " = " + result + "\n");
                        System.out.println(numberAsFloat + " ^ " + dummy + " = " + result);
                    }
                    System.out.println("-----------");
                } else {
                    java.awt.Toolkit.getDefaultToolkit().beep();
                    exit.setText("Wprowadzono nieprawidłową liczbę!");
                }
            });
            JButton exitButton = new JButton("Wyjdź");
            exitButton.setBounds(460, 320, 120, 32);
            exitButton.addActionListener(actionEvent -> {
                powerFrame.dispose();
                Util.POWER_OPENED = false;
                System.out.println("Zamknięto okno \"Potęgowanie\"!");
            });

            Component[] frameElements = {exitButton, number, numberQuestion, howManyTimes, howManyTimesQuestion, calculate, scroll};
            for (Component frameElement : frameElements) powerFrame.add(frameElement);
        }
    }
}
