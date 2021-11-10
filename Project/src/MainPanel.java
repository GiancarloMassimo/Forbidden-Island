import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;

public class MainPanel extends JPanel{
    private BufferedImage backgroundImage;
    public MainPanel(){
        try {
            backgroundImage = ImageIO.read(MainPanel.class.getResource("/Images/background.png"));
        }
        catch(Exception E)
        {
            System.out.println("Exception Error");
            return;
        }
    }
    public void paint(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, 920, 518, null);
    }
}
