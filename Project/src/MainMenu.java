import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random.*;
import java.awt.FlowLayout;

public class MainMenu extends JFrame implements ActionListener {
    private static final int WIDTH = 936;
    private static final int HEIGHT = 557;
    public MainMenu(String framename){
        super(framename);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        JButton btn = new JButton("Click Here");
        btn.setBounds(50, 100, 95, 30);
        add(btn);
        setResizable(false);
        setLayout(null);
        add(new MainPanel());
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
