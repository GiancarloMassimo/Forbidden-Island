import java.awt.*;
import javax.swing.*;

public class MainMenu extends JFrame {
    private static final int WIDTH = 1600;
    private static final int HEIGHT = 900;
    public MainMenu(String framename){
        super(framename);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setVisible(true);
    }
}
