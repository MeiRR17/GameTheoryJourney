package entity;

import main.GamePanel;
import main.KeyControlCenter;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity {
    GamePanel gamePanel;
    KeyControlCenter keyControlCenter;

    public Player(GamePanel gamePanel, KeyControlCenter keyHandler){

        this.gamePanel = gamePanel;
        this.keyControlCenter = keyHandler;

        setDefaultValue();
        getPlayerImage();
    }

    public void setDefaultValue() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            down_stand = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/front-stand.png")));
            down_move = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/front-walk.png")));
            down_move2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/front-walk2.png")));

            up_stand = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/behind-stand.png")));
            up_move = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/behind-walk.png")));
            up_move2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/behind-walk2.png")));

            right_stand = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/right-stand.png")));
            right_move = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/right-walk.png")));
            right_move2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/right-walk2.png")));

            left_stand = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/left-stand.png")));
            left_move = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/left-walk.png")));
            left_move2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/left-walk2.png")));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        if(keyControlCenter.pressUp || keyControlCenter.pressDown || keyControlCenter.pressLeft || keyControlCenter.pressRight) {
            if (keyControlCenter.pressUp && !keyControlCenter.pressDown) {
                direction = "up";
                y -= speed;
            }
            if (keyControlCenter.pressDown && !keyControlCenter.pressUp) {
                direction = "down";
                y += speed;
            }
            if (keyControlCenter.pressRight && !keyControlCenter.pressLeft) {
                direction = "right";
                x += speed;
            }
            if (keyControlCenter.pressLeft && !keyControlCenter.pressRight) {
                direction = "left";
                x -= speed;
            }


            spriteCounter++;
            if (spriteCounter > 3) {
                if (spriteNum == 4) {
                    spriteNum = 1;
                }
                if (spriteNum == 3 || spriteNum == 2 || spriteNum == 1) {
                    spriteNum++;
                }
                if(keyControlCenter.pressRight && keyControlCenter.pressLeft || keyControlCenter.pressUp && keyControlCenter.pressDown) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        } else {
            spriteNum = 1;
        }
    }

    public void draw(Graphics2D g2){
        BufferedImage image = null;
        switch (direction) {
            case "up":
                if(spriteNum == 1) {
                    image = up_stand;
                }
                if(spriteNum == 2){
                    image = up_move;
                }
                if(spriteNum == 3){
                    image = up_stand;
                }
                if(spriteNum == 4){
                    image = up_move2;
                }
                break;
            case "down":
                if(spriteNum == 1) {
                    image = down_stand;
                }
                if(spriteNum == 2){
                    image = down_move;
                }
                if(spriteNum == 3){
                    image = down_stand;
                }
                if(spriteNum == 4){
                    image = down_move2;
                }
                break;
            case "left":
                if(spriteNum == 1) {
                    image = left_stand;
                }
                if(spriteNum == 2){
                    image = left_move;
                }
                if(spriteNum == 3){
                    image = left_stand;
                }
                if(spriteNum == 4){
                    image = left_move2;
                }
                break;
            case "right":
                if(spriteNum == 1) {
                    image = right_stand;
                }
                if(spriteNum == 2){
                    image = right_move2;
                }
                if(spriteNum == 3){
                    image = right_stand;
                }
                if(spriteNum == 4){
                    image = right_move;
                }
                break;
        }
        g2.drawImage(image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
    }
}
