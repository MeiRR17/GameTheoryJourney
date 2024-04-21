package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class TileManager {

    GamePanel gamePanel;
    Tile[] tile;
    int[][] mapTileNum;

    public TileManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        tile = new Tile[10];
        mapTileNum = new int[gamePanel.maxScreenColumn][gamePanel.maxScreenRow];
        getTileImage();
        loadMap("/maps/sampleMap.txt");
    }

    public void getTileImage() {

        try{

            tile[0] = new Tile();
            tile[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResource("/tiles/grass.png")));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResource("/tiles/wall.png")));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(Objects.requireNonNull(getClass().getResource("/tiles/water.png")));

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void loadMap(String path) {

        try {
            InputStream inputStream = getClass().getResourceAsStream(path);
            assert inputStream != null;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            int column = 0;
            int row = 0;

            while (column < gamePanel.maxScreenColumn && row < gamePanel.maxScreenRow) {

                String line = bufferedReader.readLine();

                while (column < gamePanel.maxScreenColumn) {

                    String[] numbers = line.split(" ");

                    int num = Integer.parseInt(numbers[column]);

                    mapTileNum[column][row] = num;
                    column++;
                }
                if(column == gamePanel.maxScreenColumn) {
                    column = 0;
                    row++;
                }
            }
            bufferedReader.close();


        }catch (Exception ignored) {

        }

    }

    public void  draw(Graphics2D g2){

        int column = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while(column < gamePanel.maxScreenColumn && row < gamePanel.maxScreenRow) {

            int tileNum = mapTileNum[column][row];

            g2.drawImage(tile[tileNum].image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
            column++;
            x += gamePanel.tileSize;

            if(column == gamePanel.maxScreenColumn){
                column = 0;
                x = 0;
                row++;
                y += gamePanel.tileSize;
            }

        }
    }
}
