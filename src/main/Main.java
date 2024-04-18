package main;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Sets the operation that will happen by default when the user initiates a "close" on this frame. You must specify one of the following choices:
        window.setResizable(false); // Sets whether this frame is resizable by the user.
        window.setTitle("On it");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null); //center of the screen
        window.setVisible(true); //shows or hide window
        gamePanel.startGameThread();
    }
}