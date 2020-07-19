package pl.oliwier975.liczydlogui.operations.gui;

import pl.oliwier975.liczydlogui.Util;

import javax.swing.*;

import java.awt.*;

import static pl.oliwier975.liczydlogui.Util.isAllowed;

public class MultiplicationGUI {
    public MultiplicationGUI() {
        if (!Util.MULTIPLICATION_OPENED) {
            Util.MULTIPLICATION_OPENED = true;
            System.out.println("Otworzono okno \"Mnożenie\"!");

            JFrame multiplicationFrame = new JFrame("Mnożenie");
            multiplicationFrame.setSize(600, 400);
            multiplicationFrame.setLayout(null);
            multiplicationFrame.setVisible(true);
            multiplicationFrame.setResizable(false);
            multiplicationFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

            JTextField multiplicand = new JTextField();
            multiplicand.setBounds(20,30,100,32);

            JTextField multiplicandQuestion = new JTextField("Jaką liczbę chcesz wymnożyć?");
            multiplicandQuestion.setBounds(20,10,250,20);
            multiplicandQuestion.setEditable(false);

            JTextField multiplier = new JTextField();
            multiplier.setBounds(20,90,100,32);

            JTextField multiplierQuestion = new JTextField("Ile razy?");
            multiplierQuestion.setBounds(20,70,250,20);
            multiplierQuestion.setEditable(false);

            JTextArea exit = new JTextArea();
            exit.setEditable(false);

            JScrollPane scroll = new JScrollPane(exit);
            scroll.setVerticalScrollBarPolicy(scroll.VERTICAL_SCROLLBAR_AS_NEEDED);
            scroll.setBounds(300,10,280,300);

            JButton calculate = new JButton("Kalkuluj");
            calculate.setBounds(20,140,120,32);
            calculate.addActionListener(actionEvent -> {
                exit.setText("");
                if (isAllowed(multiplicand.getText(),"0",multiplier.getText())) {
                    System.out.println("-----------");
                    float multiplicandAsFloat = Float.parseFloat(multiplicand.getText());
                    int multiplierAsInt = Integer.parseInt(multiplier.getText());
                    for (int dummy = 1; dummy <= multiplierAsInt; ++dummy) {
                        float result = multiplicandAsFloat * dummy;
                        exit.append(multiplicandAsFloat + " * " + dummy + " = " + result + "\n");
                        System.out.println(multiplicandAsFloat + " * " + dummy + " = " + result);
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
                multiplicationFrame.dispose();
                Util.MULTIPLICATION_OPENED = false;
                System.out.println("Zamknięto okno \"Mnożenie\"!");
            });

            Component[] frameElements = {exitButton, multiplicand, multiplicandQuestion, multiplier, multiplierQuestion, calculate, scroll};
            for (Component frameElement : frameElements) multiplicationFrame.add(frameElement);
        }
    }
}
