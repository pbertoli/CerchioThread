package cerchiothread;

import java.awt.*;
import javax.swing.JFrame;

public class Finestra extends JFrame {

    public static final int FRAME_WITH = 500;
    public static final int FRAME_HEIGHT = 400;

    public Finestra() {
        setTitle("Al momento un cerchietto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(FRAME_WITH, FRAME_HEIGHT));

        setLayout(new GridLayout(1, 1, 3, 3));
        Cerchio c = new Cerchio();
        c.getThread().start();
        
        add(c);

        pack();
        setVisible(true);
    }
}
