import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    //screen settings
    final int orgTileSize = 16; //16x16 tile
    final int scale = 5; //scaling the tile to make it bigger

    final int tileSize = orgTileSize * scale;
    final int maxScreenColumn = 16;
    final int maxScreenRow = 10;
    final int screenWidth = tileSize * maxScreenColumn; // 120 pixels
    final int screenHeight = tileSize * maxScreenRow;



    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); // Set the wanted size of the panel
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); //set this component to be double buffered


    }
}
