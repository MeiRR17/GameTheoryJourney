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

    Thread gameThread;


    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); // Set the wanted size of the panel
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); //set this component to be double buffered


    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        while(gameThread != null){

            // UPDATE : update information
            update();
            //DRAW : draw the screen (basically the FPS of the game)
            repaint();

        }
    }
    public void update(){

    }

    //To draw something on the screen
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.CYAN);

        g2.fillRect(100, 100, tileSize, tileSize);

        g2.dispose(); //dispose of this graphics context and release any system resources
    }
}
