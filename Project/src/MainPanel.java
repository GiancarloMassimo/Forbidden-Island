import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;

public class MainPanel extends JPanel{
    private BufferedImage bg;
    public MainPanel(){
        try {
            bg = ImageIO.read(MainPanel.class.getResource("/Images/background.png"));
        }
        catch(Exception E)
        {
            System.out.println("Exception Error");
            return;
        }
    }
    public void paint(Graphics g){
        g.drawImage(bg, 0, 0, 920, 518, null);
    }
}
