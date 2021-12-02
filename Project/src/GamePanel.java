import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.util.Objects;
import javax.imageio.ImageIO;

public class GamePanel extends JPanel{
    private BufferedImage backGroundImage,floodCardBackImage,treasureCardBackImage, waterMarkerImage;

    public GamePanel(){
        FloodDeck.gamePanel = this;
        try {
            backGroundImage = ImageIO.read(GamePanel.class.getResource("/Images/background.png"));
            floodCardBackImage = ImageIO.read(GamePanel.class.getResource("/Images/FloodCardBack.png"));
            treasureCardBackImage = ImageIO.read(GamePanel.class.getResource("/Images/TreasureCardBack.png"));
            waterMarkerImage = ImageIO.read(GamePanel.class.getResource("/Images/Watermeter.png"));

        }
        catch(Exception E)
        {
            System.out.println("Exception Error");
            return;
        }
    }
    public void paint(Graphics g){
        g.drawImage(backGroundImage, 0, 0, 1600, 960, null);

        drawMap(g);
        drawWaterMaker(g);
        drawDecks(g);
        drawFloodDeck(g);
    }

    private void drawMap(Graphics g) {
        //Draw translucent rectangle behind the map
          int marginX = 22, marginY = 55, containerWidth = 1021, containerHeight = 850;

        g.setColor(new Color(0, 0, 0, 150));
        g.fillRect(marginX, marginY, containerWidth, containerHeight);

        // Draw the actual map
        int tileSize = 120, offsetX = 73, offsetY = 120, spacing = 120;

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
    private void drawDecks(Graphics g){g.drawImage(treasureCardBackImage, 782, 65, 128, 188, null);}
    private void drawWaterMaker(Graphics g) {
        g.drawImage(waterMarkerImage, 869, 262, 160, 440, null);

        //water level

        int x = 525;
        int yOffset = 397;
        int ySpacing = 30;
        g.setColor(Color.red);
        g.fillRect(x, yOffset - ySpacing * (WaterLevel.waterMarkerLevel - 1), 75, 15);
    }
    private void drawFloodDeck(Graphics g) {
        g.drawImage(floodCardBackImage, 782, 708, 128, 188, null);
        g.drawImage(Main.floodDeck.discardPileImage, 910, 708, 128, 188, null);
    }
}
