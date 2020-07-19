package pl.oliwier975.liczydlogui.operations.gui;

import pl.oliwier975.liczydlogui.Util;

import javax.swing.*;
import java.awt.*;

import static pl.oliwier975.liczydlogui.Util.isAllowed;

public class AdditionGUI {
    public AdditionGUI() {
        if (!Util.ADDITION_OPENED) {
            Util.ADDITION_OPENED = true;
            System.out.println("Otworzono okno \"Dodawanie\"!");

            JFrame additionFrame = new JFrame("Dodawanie");
            additionFrame.setSize(600, 400);
            additionFrame.setLayout(null);
            additionFrame.setVisible(true);
            additionFrame.setResizable(false);
            additionFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

            JTextField component1 = new JTextField();
            component1.setBounds(20,30,100,32);

            JTextField component1Question = new JTextField("Pierwszy składnik dodawania:");
            component1Question.setBounds(20,10,250,20);
            component1Question.setEditable(false);

            JTextField component2 = new JTextField();
            component2.setBounds(20,90,100,32);

            JTextField component2Question = new JTextField("Drugi składnik dodawania:");
            component2Question.setBounds(20,70,250,20);
            component2Question.setEditable(false);

            JTextField howManyTimes = new JTextField();
            howManyTimes.setBounds(20,150,100,32);

            JTextField howManyTimesQuestion = new JTextField("Ile razy chcesz dodawać?");
            howManyTimesQuestion.setBounds(20,130,250,20);
            howManyTimesQuestion.setEditable(false);

            JTextArea exit = new JTextArea();
            exit.setEditable(false);

            JScrollPane scroll = new JScrollPane(exit);
            scroll.setVerticalScrollBarPolicy(scroll.VERTICAL_SCROLLBAR_AS_NEEDED);
            scroll.setBounds(300,10,280,300);

            JButton calculate = new JButton("Kalkuluj");
            calculate.setBounds(20,200,120,32);
            calculate.addActionListener(actionEvent -> {
                exit.setText("");
                if (isAllowed(component1.getText(),component2.getText(),howManyTimes.getText())){
                    System.out.println("-----------");
                    float component1AsFloat = Float.parseFloat(component1.getText());
                    float component2AsFloat = Float.parseFloat(component2.getText());
                    int howManyTimesAsInt = Integer.parseInt(howManyTimes.getText());
                    for (int dummy = 1; dummy <= howManyTimesAsInt; ++dummy) {
                        float result = component1AsFloat + component2AsFloat;
                        exit.append(component1AsFloat + " + " + component2AsFloat + " = " + result + "\n");
                        System.out.println(component1AsFloat + " + " + component2AsFloat + " = " + result);
                        component1AsFloat = component1AsFloat + component2AsFloat;
                    }
                    System.out.println("-----------");
                } else {
                    Toolkit.getDefaultToolkit().beep();
                    exit.setText("Wprowadzono nieprawidłową liczbę!");
                }
            });

            JButton exitButton = new JButton("Wyjdź");
            exitButton.setBounds(460, 320, 120, 32);
            exitButton.addActionListener(actionEvent -> {
                additionFrame.dispose();
                Util.ADDITION_OPENED = false;
                System.out.println("Zamknięto okno \"Dodawanie\"!");
            });

            Component[] frameElements = {exitButton, component1, component1Question, component2, component2Question, howManyTimes,
                    howManyTimesQuestion, calculate, scroll};
            for (Component frameElement : frameElements) additionFrame.add(frameElement);
        }
    }
}
