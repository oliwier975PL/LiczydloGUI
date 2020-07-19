package pl.oliwier975.liczydlogui.operations.gui;

import pl.oliwier975.liczydlogui.Util;

import javax.swing.*;

import java.awt.*;

import static pl.oliwier975.liczydlogui.Util.isAllowed;

public class DivisionGUI {
    public DivisionGUI() {
        if (!Util.DIVISION_OPENED) {
            Util.DIVISION_OPENED = true;
            System.out.println("Otworzono okno \"Dzielenie\"!");

            JFrame divisionFrame = new JFrame("Dzielenie");
            divisionFrame.setSize(600, 400);
            divisionFrame.setLayout(null);
            divisionFrame.setVisible(true);
            divisionFrame.setResizable(false);
            divisionFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

            JTextField dividend = new JTextField();
            dividend.setBounds(20,30,100,32);

            JTextField dividendQuestion = new JTextField("Jaką liczbę chcesz dzielić?");
            dividendQuestion.setBounds(20,10,250,20);
            dividendQuestion.setEditable(false);

            JTextField divider = new JTextField();
            divider.setBounds(20,90,100,32);

            JTextField dividerQuestion = new JTextField("Jaka jest liczba, od której chcesz dzielić?");
            dividerQuestion.setBounds(20,70,250,20);
            dividerQuestion.setEditable(false);

            JTextArea exit = new JTextArea();
            exit.setEditable(false);

            JScrollPane scroll = new JScrollPane(exit);
            scroll.setVerticalScrollBarPolicy(scroll.VERTICAL_SCROLLBAR_AS_NEEDED);
            scroll.setBounds(300,10,280,300);

            JButton calculate = new JButton("Kalkuluj");
            calculate.setBounds(20,140,120,32);
            calculate.addActionListener(actionEvent -> {
                exit.setText("");
                if (isAllowed(dividend.getText(),"0",divider.getText())) {
                    System.out.println("-----------");
                    float dividendAsFloat = Float.parseFloat(dividend.getText());
                    int dividerAsInt = Integer.parseInt(divider.getText());
                    for (int dummy = dividerAsInt; dummy >= 1; --dummy) {
                        float result = dividendAsFloat / dummy;
                        exit.append(dividendAsFloat + " / " + dummy + " = " + result + "\n");
                        System.out.println(dividendAsFloat + " / " + dummy + " = " + result);
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
                divisionFrame.dispose();
                Util.DIVISION_OPENED = false;
                System.out.println("Zamknięto okno \"Dzielenie\"!");
            });

            Component[] frameElements = {exitButton, dividend, dividendQuestion, divider, dividerQuestion, calculate, scroll};
            for (Component frameElement : frameElements) divisionFrame.add(frameElement);
        }
    }
}
