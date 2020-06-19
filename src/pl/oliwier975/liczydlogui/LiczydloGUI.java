package pl.oliwier975.liczydlogui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class LiczydloGUI {
    public static int dodawanie_openchecker = 0;
    public static int mnozenie_openchecker = 0;
    public static int dzielenie_openchecker = 0;
    public static void cli_help(){
        System.out.println("Available arguments:");
        System.out.println("dodawanie");
        System.out.println("↳ Dodaje wiele liczb.");
        System.out.println("mnozenie");
        System.out.println("↳ Duzo mnozy.");
        System.out.println("dzielenie");
        System.out.println("↳ Dzieli w dol.");
        System.out.println("--help");
        System.out.println("↳ Prints this message.");
    }
    public static void cli_dodawanie(){
        Scanner input1 = new Scanner(System.in);
        System.out.print("Podaj liczbę, którą chcesz pododawać: ");
        float liczba1 = input1.nextFloat();
        Scanner input2 = new Scanner(System.in);
        System.out.print("Podaj jaką liczbą chcesz ją pododawać: ");
        float liczba2 = input2.nextFloat();
        Scanner input3 = new Scanner(System.in);
        System.out.print("Podaj ile razy chcesz ją pododawać: ");
        int liczba3 = input3.nextInt();
        float kurier;
        System.out.println("-----------");
        for (int dummy = 1; dummy <= liczba3; ++dummy) {
            kurier = liczba1 + liczba2;
            System.out.println(liczba1 + " + " + liczba2 + " = " + kurier);
            liczba1 = liczba1 + liczba2;
        }
        System.out.println("-----------");
    }
    public static void cli_mnozenie(){
        Scanner input1 = new Scanner(System.in);
        System.out.print("Podaj liczbę, którą chcesz wymnożyć: ");
        float liczba1 = input1.nextFloat();
        Scanner input2 = new Scanner(System.in);
        System.out.print("Podaj ile razy chcesz ją wymnożyć: ");
        int liczba2 = input2.nextInt();
        float kurier;
        System.out.println("-----------");
        for (int dummy = 1; dummy <= liczba2; ++dummy) {
            kurier = liczba1 * dummy;
            System.out.println(liczba1 + " * " + dummy + " = " + kurier);
        }
        System.out.println("-----------");
    }
    public static void cli_dzielenie(){
        Scanner input1 = new Scanner(System.in);
        System.out.print("Podaj liczbe, która chcesz popodzielać: ");
        float liczba1 = input1.nextFloat();
        Scanner input2 = new Scanner(System.in);
        System.out.print("Podaj liczbę, od której chcesz dzielić: ");
        int liczba2 = input2.nextInt();
        float kurier;
        System.out.println("-----------");
        for (int dummy = liczba2; dummy >= 1; --dummy) {
            kurier = liczba1 / dummy;
            System.out.println(liczba1 + " / " + dummy + " = " + kurier);
        }
        System.out.println("-----------");
    }
    public static void dodawanie_open() {
        if (dodawanie_openchecker == 0) {
            dodawanie_openchecker = 1;
            System.out.println("Window Dodawanie opened!");
            JFrame dodawanie_frame = new JFrame("Dodawanie");
            dodawanie_frame.setSize(600, 400);
            dodawanie_frame.setLayout(null);
            dodawanie_frame.setVisible(true);
            dodawanie_frame.setResizable(false);
            dodawanie_frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            JTextField liczba1 = new JTextField();
            liczba1.setBounds(20,30,100,32);
            JTextField tekst1 = new JTextField("Podaj liczbę, którą chcesz pododawać");
            tekst1.setBounds(20,10,250,20); tekst1.setEditable(false);
            JTextField liczba2 = new JTextField();
            liczba2.setBounds(20,90,100,32);
            JTextField tekst2 = new JTextField("Podaj jaką liczbą chcesz ją pododawać");
            tekst2.setBounds(20,70,250,20); tekst2.setEditable(false);
            JTextField liczba3 = new JTextField();
            liczba3.setBounds(20,150,100,32);
            JTextField tekst3 = new JTextField("Podaj ile razy chcesz ją pododawać");
            tekst3.setBounds(20,130,250,20); tekst3.setEditable(false);
            JTextArea wyjscie = new JTextArea();
            wyjscie.setBounds(300,10,280,300); wyjscie.setEditable(false);
            JButton kalkuluj = new JButton("Kalkuluj");
            kalkuluj.setBounds(20,200,120,32);
            kalkuluj.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    wyjscie.setText("");
                    System.out.println("-----------");
                    float dana1 = Float.parseFloat(liczba1.getText());
                    float dana2 = Float.parseFloat(liczba2.getText());
                    float dana3 = Float.parseFloat(liczba3.getText());
                    float kurier;
                    for (int dummy = 1; dummy <= dana3; ++dummy) {
                        kurier = dana1 + dana2;
                        wyjscie.append(dana1 + " + " + dana2 + " = " + kurier + "\n");
                        System.out.println(dana1 + " + " + dana2 + " = " + kurier);
                        dana1 = dana1 + dana2;
                    }
                    System.out.println("-----------");
                }
            });
            JButton exit = new JButton("Wyjdź");
            exit.setBounds(460, 320, 120, 32);
            dodawanie_frame.add(exit); dodawanie_frame.add(liczba1); dodawanie_frame.add(tekst1); dodawanie_frame.add(liczba2); dodawanie_frame.add(tekst2); dodawanie_frame.add(liczba3); dodawanie_frame.add(tekst3); dodawanie_frame.add(kalkuluj); dodawanie_frame.add(wyjscie);
            exit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    dodawanie_frame.dispose();
                    dodawanie_openchecker=0;
                    System.out.println("Windows Dodawanie closed!");
                }
            });
        } else {
            System.out.println("Window Dodawanie is already opened!");
        }
        }
    public static void mnozenie_open() {
        if (mnozenie_openchecker == 0) {
            mnozenie_openchecker = 1;
            System.out.println("Window Mnożenie opened!");
            JFrame mnozenie_frame = new JFrame("Mnożenie");
            mnozenie_frame.setSize(600, 400);
            mnozenie_frame.setLayout(null);
            mnozenie_frame.setVisible(true);
            mnozenie_frame.setResizable(false);
            mnozenie_frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            JTextField liczba1 = new JTextField();
            liczba1.setBounds(20,30,100,32);
            JTextField tekst1 = new JTextField("Podaj liczbę, którą chcesz wymnożyć");
            tekst1.setBounds(20,10,250,20); tekst1.setEditable(false);
            JTextField liczba2 = new JTextField();
            liczba2.setBounds(20,90,100,32);
            JTextField tekst2 = new JTextField("Podaj ile razy chcesz ją wymnożyć");
            tekst2.setBounds(20,70,250,20); tekst2.setEditable(false);
            JTextArea wyjscie = new JTextArea();
            wyjscie.setBounds(300,10,280,300); wyjscie.setEditable(false);
            JButton kalkuluj = new JButton("Kalkuluj");
            kalkuluj.setBounds(20,140,120,32);
            kalkuluj.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    wyjscie.setText("");
                    System.out.println("-----------");
                    float dana1 = Float.parseFloat(liczba1.getText());
                    float dana2 = Float.parseFloat(liczba2.getText());
                    float kurier;
                    for (int dummy = 1; dummy <= dana2; ++dummy){
                        kurier = dana1 * dummy;
                        wyjscie.append(dana1 + " * " + dummy + " = " + kurier + "\n");
                        System.out.println(dana1 + " * " + dummy + " = " + kurier);
                    }
                    System.out.println("-----------");
                }
            });
            JButton exit = new JButton("Wyjdź");
            exit.setBounds(460, 320, 120, 32);
            mnozenie_frame.add(exit); mnozenie_frame.add(liczba1); mnozenie_frame.add(tekst1); mnozenie_frame.add(liczba2); mnozenie_frame.add(tekst2); mnozenie_frame.add(kalkuluj); mnozenie_frame.add(wyjscie);
            exit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    mnozenie_frame.dispose();
                    mnozenie_openchecker=0;
                    System.out.println("Windows Mnożenie closed!");
                }
            });
        } else {
            System.out.println("Window Mnozenie is already opened!");
        }
    }
    public static void dzielenie_open() {
        if (dzielenie_openchecker == 0) {
            dzielenie_openchecker = 1;
            System.out.println("Window Dzielenie opened!");
            JFrame dzielenie_frame = new JFrame("Dzielenie");
            dzielenie_frame.setSize(600, 400);
            dzielenie_frame.setLayout(null);
            dzielenie_frame.setVisible(true);
            dzielenie_frame.setResizable(false);
            dzielenie_frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            JTextField liczba1 = new JTextField();
            liczba1.setBounds(20,30,100,32);
            JTextField tekst1 = new JTextField("Podaj liczbę, którą chcesz popodzielać");
            tekst1.setBounds(20,10,250,20); tekst1.setEditable(false);
            JTextField liczba2 = new JTextField();
            liczba2.setBounds(20,90,100,32);
            JTextField tekst2 = new JTextField("Podaj liczbę, od której chcesz dzielić");
            tekst2.setBounds(20,70,250,20); tekst2.setEditable(false);
            JTextArea wyjscie = new JTextArea();
            wyjscie.setBounds(300,10,280,300); wyjscie.setEditable(false);
            JButton kalkuluj = new JButton("Kalkuluj");
            kalkuluj.setBounds(20,140,120,32);
            kalkuluj.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    wyjscie.setText("");
                    System.out.println("-----------");
                    float dana1 = Float.parseFloat(liczba1.getText());
                    int dana2 = Integer.parseInt(liczba2.getText());
                    float kurier;
                    for (int dummy = dana2; dummy >= 1; --dummy){
                        kurier = dana1 / dummy;
                        wyjscie.append(dana1 + " / " + dummy + " = " + kurier + "\n");
                        System.out.println(dana1 + " / " + dummy + " = " + kurier);
                    }
                    System.out.println("-----------");
                }
            });
            JButton exit = new JButton("Wyjdź");
            exit.setBounds(460, 320, 120, 32);
            dzielenie_frame.add(exit); dzielenie_frame.add(liczba1); dzielenie_frame.add(tekst1); dzielenie_frame.add(liczba2); dzielenie_frame.add(tekst2); dzielenie_frame.add(kalkuluj); dzielenie_frame.add(wyjscie);
            exit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    dzielenie_frame.dispose();
                    dzielenie_openchecker=0;
                    System.out.println("Window Dzielenie closed!");
                }
            });
        } else {
            System.out.println("Window Dzielenie is already opened!");
        }
    }
    public static void main(String[] args) {
        String Version = "0.1.3";
        System.out.println("LiczydłoGUI " + Version);
        if (args.length > 0) {
            System.out.println("Using cli interface.");
            if (args[0].equals("--cli") | args[0].equals("-c")){
                if (args.length > 1){
                    if (args[1].isEmpty()){
                        System.out.println("Type --cli --help for usage.");
                    } else if (args[1].equals("--help") | args[1].equals("-h")) {
                        cli_help();
                    } else if (args[1].equals("dodawanie") | args[1].equals("-a")) {
                        cli_dodawanie();
                    } else if (args[1].equals("mnozenie") | args[1].equals("-m")){
                        cli_mnozenie();
                    } else if (args[1].equals("dzielenie") | args[1].equals("-d")){
                        cli_dzielenie();
                    } else {
                        System.out.println("Bad argument. Type --cli --help for usage.");
                    }
                } else {
                    System.out.println("Type --cli --help for usage.");
                }
            } else {
                System.out.println("Bad argument. Type --cli --help for usage.");
            }
        } else {
            System.out.println("You can use --cli argument for cli interface.");
            JFrame ramka = new JFrame("LiczydłoGUI");
            ramka.setSize(440, 110);
            ramka.setLayout(null);
            ramka.setVisible(true);
            ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            System.out.println("Opened Main window!");
            JButton dodawanie = new JButton("Dodawanie");
            dodawanie.setBounds(20, 20, 120, 32);
            ramka.add(dodawanie);
            dodawanie.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    dodawanie_open();
                }
            });
            JButton mnozenie = new JButton("Mnożenie");
            mnozenie.setBounds(160, 20, 120, 32);
            ramka.add(mnozenie);
            mnozenie.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    mnozenie_open();
                }
            });
            JButton dzielenie = new JButton("Dzielenie");
            dzielenie.setBounds(300, 20, 120, 32);
            ramka.add(dzielenie);
            dzielenie.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    dzielenie_open();
                }
            });
        }
    }
}
