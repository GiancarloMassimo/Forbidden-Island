import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.ImageIO;

public class MainMenuPanel extends JPanel{
    private BufferedImage backGroundImage,floodCardBackImage,treasureCardBackImage, waterMarkerImage;

    public MainMenuPanel(){
        FloodDeck.gamePanel = this;
        try {
            backGroundImage = ImageIO.read(MainMenuPanel.class.getResource("/Images/background.png"));
            floodCardBackImage = ImageIO.read(MainMenuPanel.class.getResource("/Images/FloodCardBack.png"));
            treasureCardBackImage = ImageIO.read(MainMenuPanel.class.getResource("/Images/TreasureCardBack.png"));
            waterMarkerImage = ImageIO.read(MainMenuPanel.class.getResource("/Images/Watermeter.png"));
        }
        catch(Exception E)
        {
            System.out.println("Exception Error");
            return;
        }
    }
    public void paint(Graphics g){
        g.drawImage(backGroundImage, 0, 0, 936, 557, null);
        g.drawImage(floodCardBackImage, 782, 300, 128, 188, null);
        g.drawImage(treasureCardBackImage, 782, 65, 128, 188, null);

        drawMap(g);
        drawWaterMaker(g);
    }

    private void drawMap(Graphics g) {
        //Draw translucent rectangle behind the map
        int marginX = 10, marginY = 10, containerWidth = 650, containerHeight = 500;

        g.setColor(new Color(0, 0, 0, 150));
        g.fillRect(marginX, marginY, containerWidth, containerHeight);

        // Draw the actual map
        int tileSize = 75, offsetX = 20, offsetY = 24, spacing = 80;

        Tile[][] map = Map.instance.getMap();
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 6; c++) {
                if (map[r][c] == null) {
                    continue;
                }
                g.drawImage(map[r][c].getCurrentImage(), offsetX + c * spacing, offsetY + r * spacing, tileSize, tileSize, null);
            }
        }
    }

    private void drawWaterMaker(Graphics g) {
        g.drawImage(waterMarkerImage, 550, 100, 130, 358, null);
    }
}
