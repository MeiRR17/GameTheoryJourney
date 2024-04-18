import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    //screen settings
    final int orgTileSize = 16; //16x16 tile
    final int scale = 5; //scaling the tile to make it bigger

    final int tileSize = orgTileSize * scale;
    final int maxScreenColumn = 16;
    final int maxScreenRow = 10;
    final int screenWidth = tileSize * maxScreenColumn; // 120 pixels
    final int screenHeight = tileSize * maxScreenRow;

    int FPS = 30;


    KeyControlCenter keyControlCenter = new KeyControlCenter();
    Thread gameThread;

    //Player's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); // Set the wanted size of the panel
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); //set this component to be double buffered
        this.addKeyListener(keyControlCenter);
        this.setFocusable(true); //make the gamePanel receive key input

    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double interval = (double) 1000000000 /FPS;
        double nextDrawTime = System.nanoTime() + interval;

        while(gameThread != null){

            // UPDATE : update information
            update();
            //DRAW : draw the screen (basically the FPS of the game)
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime/= 1000000;

                if(remainingTime < 0){
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += interval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
    public void update(){

        if(keyControlCenter.pressUp) {
            playerY -= playerSpeed;
        }
        if(keyControlCenter.pressDown) {
            playerY += playerSpeed;
        }
        if(keyControlCenter.pressRight) {
            playerX += playerSpeed;
        }
        if(keyControlCenter.pressLeft) {
            playerX -= playerSpeed;
        }

    }

    //To draw something on the screen
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.CYAN);

        g2.fillRect(playerX, playerY, tileSize, tileSize);

        g2.dispose(); //dispose of this graphics context and release any system resources
    }
}
