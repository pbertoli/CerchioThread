package cerchiothread;

import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class Cerchio extends JPanel implements Runnable {

    public final static int PANEL_WIDTH = 500;
    public final static int PANEL_HEIGHT = 400;
    public final static int OVAL_SIZE = 100;

    int x = 0, y = 0, dx = 2, dy = 2;
    Random ran = new Random();
    Thread animator = new Thread(this);

    public Thread getThread() {
        return animator;
    }

    public Cerchio() {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        x = ran.nextInt(PANEL_WIDTH - OVAL_SIZE -15);
        y = ran.nextInt(PANEL_HEIGHT - OVAL_SIZE -40);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.ORANGE);
        g.fillOval(x, y, OVAL_SIZE, OVAL_SIZE);
    }

    private void cycle() {
        if (x + dx < 0) {
            dx = -dx;
        }
        if (x + dx > PANEL_WIDTH - OVAL_SIZE-15) {
            dx = -dx;
        }
        if (y + dy < 0) {
            dy = -dy;
        }
        if (y + dy > PANEL_HEIGHT - OVAL_SIZE-40) {
            dy = -dy;
        }
        x += dx;
        y += dy;
        repaint();
    }

    public void run() {
        while (true) {
            cycle();
            try {
            Thread.currentThread().sleep(30);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

}
