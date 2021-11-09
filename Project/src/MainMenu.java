import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random.*;

public class MainMenu extends JFrame implements ItemListener, ActionListener {
    private Container win;

    private JLabel screenLabel, inputLabel, outputLabel, inputBaseLabel;
    private JTextField inputField;
    private JScrollPane scrollPane;
    private JTextArea outputArea;
    private JCheckBox binCheck, hexCheck, decCheck;
    private JButton printButton;
    private JRadioButton dec_irbutton, bin_irbutton, hex_irbutton;
    private ButtonGroup  input_radioGroup;

    private static final int WIDTH = 936;
    private static final int HEIGHT = 557;
    public MainMenu(String framename){
        super(framename);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        add(new MainPanel());
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}
