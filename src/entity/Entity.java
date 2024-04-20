package entity;

import java.awt.image.BufferedImage;

public class Entity {

    public int x, y;
    public int speed;

    public BufferedImage up_stand, up_move, up_move2, down_stand, down_move, down_move2, right_stand, right_move, right_move2, left_stand, left_move, left_move2;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;
}
