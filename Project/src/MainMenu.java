import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random.*;
import java.awt.FlowLayout;

public class MainMenu extends JFrame implements ActionListener {
    private static final int WIDTH = 1616;
    private static final int HEIGHT = 999;
    private JButton playButton;
    public MainMenu(String framename){
        super(framename);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        /*playButton = new JButton("Play");
        playButton.setBounds(50, 100, 95, 30);
        add(playButton);*/
        setResizable(false);
        //setLayout(null);
        add(new MainPanel());
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
