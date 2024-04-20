package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyControlCenter implements KeyListener {

    public boolean pressUp, pressDown, pressRight, pressLeft;
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if(keyCode == KeyEvent.VK_UP) {
            pressUp = true;
        }
        if(keyCode == KeyEvent.VK_DOWN) {
            pressDown = true;
        }
        if(keyCode == KeyEvent.VK_RIGHT) {
            pressRight = true;
        }
        if(keyCode == KeyEvent.VK_LEFT) {
            pressLeft = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if(keyCode == KeyEvent.VK_UP) {
            pressUp = false;
        }
        if(keyCode == KeyEvent.VK_DOWN) {
            pressDown = false;
        }
        if(keyCode == KeyEvent.VK_RIGHT) {
            pressRight = false;
        }
        if(keyCode == KeyEvent.VK_LEFT) {
            pressLeft = false;
        }
    }
}
