import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {

    private BufferedImage backgroundImage, airTreasureCard, earthTreasureCard, fireTreasureCard, waterTreasureCard;

    //temporary hands
    private ArrayList<TreasureCard> treasureCardHandPlayer1 = new ArrayList<TreasureCard>();
    private ArrayList<TreasureCard> treasureCardHandPlayer2 = new ArrayList<TreasureCard>();
    private ArrayList<TreasureCard> treasureCardHandPlayer3 = new ArrayList<TreasureCard>();
    private ArrayList<TreasureCard> treasureCardHandPlayer4 = new ArrayList<TreasureCard>();

    public GamePanel() {
        try {
            backgroundImage = ImageIO.read(MainPanel.class.getResource("/Images/background.png"));
            airTreasureCard = ImageIO.read(MainPanel.class.getResource("/Images/AIR.png"));
            earthTreasureCard = ImageIO.read(MainPanel.class.getResource("/Images/TERRE.png"));
            fireTreasureCard = ImageIO.read(MainPanel.class.getResource("/Images/FEU.png"));
            waterTreasureCard = ImageIO.read(MainPanel.class.getResource("/Images/EAU.png"));
        }
        catch(Exception E) {
            System.out.println("Exception Error");
            return;
        }

        //temporary placeholder data



    }

    public void paint(Graphics g) {

        g.drawImage(backgroundImage, 0, 0, 1600, 960, null);

        //temporary colors, implement player-to-color correspondence later
        g.setColor(new Color(82, 164, 121));
        g.fillRoundRect(1056, 55, 516, 140, 10, 10);
        g.setColor(new Color(76, 144, 190));
        g.fillRoundRect(1056, 207, 516, 140, 10, 10);
        g.setColor(new Color(234, 117, 122));
        g.fillRoundRect(1056, 359, 516, 140, 10, 10);
        g.setColor(new Color(253, 246, 127));
        g.fillRoundRect(1056, 511, 516, 140, 10, 10);
        g.setColor(Color.white);
        for (int i = 0; i < 4; i++) {
            g.fillRoundRect(1061, 61 + 152 * i, 413, 128, 10, 10);
        }




    }

}
