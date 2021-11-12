import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.util.Objects;

public class MainPanel extends JPanel{
    private BufferedImage backGroundImage,floodCardBackImage,treasureCardBackImage;
    public MainPanel(){
        try {
            backGroundImage = ImageIO.read(Objects.requireNonNull(MainPanel.class.getResource("/Images/background.png")));
            floodCardBackImage = ImageIO.read(Objects.requireNonNull(MainPanel.class.getResource("/Images/FloodCardBack.png")));
            treasureCardBackImage = ImageIO.read(Objects.requireNonNull(MainPanel.class.getResource("/Images/TreasureCardBack.png")));
        }
        catch(Exception E)
        {
            System.out.println("Exception Error");
        }
    }
    public void paint(Graphics g){
        g.drawImage(backGroundImage, 0, 0, 1600, 960, null);
        g.drawImage(floodCardBackImage, 782, 705, 128, 188, null);
        g.drawImage(treasureCardBackImage, 782, 65, 128, 188, null);
    }
}
