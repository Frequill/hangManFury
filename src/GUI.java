import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GUI extends JFrame{
    private final int SCREEN_WIDTH = 600;
    private final int SCREEN_HEIGHT = 600;


    //GUI
    JPanel headPanel, bodyPanel;
    JLabel menuTitle, menuImage;
    JButton button;
    GUI(){
        //frame settings

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setTitle("HangMan by Group Fury");
        setLayout(new GridLayout(2,1));
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        //Panels
        headPanel = new JPanel();
        headPanel.setLayout(new FlowLayout());


        bodyPanel = new JPanel();

    }
}
