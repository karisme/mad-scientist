package SavageMode;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window(int width, int height, String title, BankSafe game) {
        JFrame frame = new JFrame(title);
        frame.add(game);

        Dimension size = new Dimension(width, height);
        frame.setPreferredSize(size);                                // JFrame window initializing
        frame.setMinimumSize(size);
        frame.setMaximumSize(size);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       // Pressing X to close game
        frame.setResizable(false);                                  // Don't resize window otherwise issues later
        frame.setLocationRelativeTo(null);                          // Makes window start in the middle (optional)
        frame.setVisible(true);                                     //makes window visible

        game.start();
        }    //starting the game


}
