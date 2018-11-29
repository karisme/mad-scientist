package SavageMode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OldWindow extends Canvas implements ActionListener {

    public OldWindow(int width, int height, String title, BankSafe game) {
        JFrame frame = new JFrame(title);
        JPanel titleScreen = new JPanel();
        frame.add(game);

        Dimension size = new Dimension(width, height);
        frame.setPreferredSize(size);                                // JFrame window initializing
        frame.setMinimumSize(size);
        frame.setMaximumSize(size);

        Container test = frame.getContentPane();

        titleScreen.setBounds(0,0,width,height);    // defines panel size and dat
        titleScreen.setBackground(Color.BLACK);                    // color

        Font descFont = new Font("Helvetica",Font.PLAIN,58);
        Font buttonFont = new Font("Times New Roman", Font.PLAIN,38);

        JLabel desc = new JLabel("ARE YOU READY TO BEGIN?");
        desc.setForeground(Color.WHITE);
        desc.setFont(descFont);
        titleScreen.add(desc);

        JPanel toggleStartOne = new JPanel();
        toggleStartOne.setBounds(400,500,200,200);
        toggleStartOne.setBackground(Color.BLACK);

        JPanel toggleStartTwo = new JPanel();
        toggleStartTwo.setBounds(800,500,200,200);
        toggleStartTwo.setBackground(Color.BLACK);

        JButton startButton = new JButton("YES");
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        startButton.setFont(buttonFont);
        toggleStartOne.add(startButton);



        JButton endButton = new JButton("NO");
        endButton.setBackground(Color.BLACK);
        endButton.setForeground(Color.WHITE);
        endButton.setFont(buttonFont);
        toggleStartTwo.add(endButton);


        test.add(toggleStartOne);
        test.add(toggleStartTwo);
        test.add(titleScreen);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       // Pressing X to close game
        frame.setResizable(false);                                  // Don't resize window otherwise issues later
        frame.setLocationRelativeTo(null);                          // Makes window start in the middle (optional)
        frame.setVisible(true);                                     //makes window visible

        endButton.addActionListener(a -> System.exit(0));

        startButton.addActionListener(e -> {
            toggleStartOne.setVisible(false);
            toggleStartOne.remove(startButton);
            toggleStartTwo.setVisible(false);
            toggleStartTwo.remove(endButton);
            desc.setVisible(false);
            titleScreen.setVisible(false);
            game.start();
        });    //starting the game

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
