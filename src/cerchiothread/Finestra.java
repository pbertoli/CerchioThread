package cerchiothread;

import java.awt.*;
import javax.swing.JFrame;

public class Finestra extends JFrame {

    public static final int FRAME_WITH = 1000;
    public static final int FRAME_HEIGHT = 1000;
    private final int N_COLONNE = 5;
    private final int N_RIGHE = 5;
    private final int N_CERCHI = N_COLONNE * N_RIGHE;
    Cerchio[] cerchi = new Cerchio[N_CERCHI];

    public Finestra() throws InterruptedException {
        setTitle("Ora più cerchietti");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(FRAME_WITH, FRAME_HEIGHT));

        setLayout(new GridLayout(N_COLONNE, N_RIGHE, 2, 2));
        for (int i = 0; i < N_CERCHI; i++) {
            cerchi[i] = new Cerchio();
            cerchi[i].getThread().start();
            add(cerchi[i]);
        }
        pack(); // predispone le dimensioni dei pannelli
        setVisible(true);

        for (int i = 0; i < N_CERCHI; i++) {
            try {
                cerchi[i].getThread().join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
