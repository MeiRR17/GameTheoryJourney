package entity;

import main.GamePanel;
import main.KeyControlCenter;

import java.awt.*;

public class Player extends Entity{
    GamePanel gamePanel;
    KeyControlCenter keyControlCenter;

    public Player(GamePanel gamePanel, KeyControlCenter keyHandler){

        this.gamePanel = gamePanel;
        this.keyControlCenter = keyHandler;

        setDefaultValue();
    }
    public void setDefaultValue() {
        x = 100;
        y = 100;
        speed = 4;
    }
    public void update(){
        if(keyControlCenter.pressUp) {
            y -= speed;
        }
        if(keyControlCenter.pressDown) {
            y += speed;
        }
        if(keyControlCenter.pressRight) {
            x += speed;
        }
        if(keyControlCenter.pressLeft) {
            x -= speed;
        }
    }
    public void draw(Graphics2D g2){
        g2.setColor(Color.CYAN);

        g2.fillRect(x, y, gamePanel.tileSize, gamePanel.tileSize);
    }
}
