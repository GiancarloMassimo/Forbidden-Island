import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.ImageIO;

public class MainMenuPanel extends JPanel{
    private BufferedImage bg;
    public MainMenuPanel(){
        try {
            bg = ImageIO.read(MainMenuPanel.class.getResource("/Images/background.png"));
        }
        catch(Exception E)
        {
            System.out.println("Exception Error");
            return;
        }
    }
    public void paint(Graphics g){
        g.drawImage(bg, 0, 0, 937, 537, null);
    }
}
