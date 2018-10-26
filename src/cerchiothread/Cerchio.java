package cerchiothread;

import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class Cerchio extends JPanel implements Runnable {

    public final static int PANEL_WIDTH = 500;
    public final static int PANEL_HEIGHT = 400;
    public final static int OVAL_SIZE = 30;

    int x = 0, y = 0, dx = 2, dy = 2;
    Random ran = new Random();
    Thread animator = new Thread(this);

    public Thread getThread() {
        return animator;
    }

    public Cerchio() {
        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        x = ran.nextInt(OVAL_SIZE)+dx;
        y = ran.nextInt(OVAL_SIZE)+dy;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(x, y, OVAL_SIZE, OVAL_SIZE);
    }

    private void cycle() {
        Rectangle r = getBounds();
        int pWidth = (int) r.getWidth();
        int pHeight = (int) r.getHeight();
        if (x < 0) {
            dx = -dx;
        }
        if (x + dx > pWidth - OVAL_SIZE) {
            dx = -dx;
        }
        if (y < 0) {
            dy = -dy;
        }
        if (y + dy > pHeight - OVAL_SIZE) {
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
