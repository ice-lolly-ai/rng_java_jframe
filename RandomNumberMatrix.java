import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class RandomNumberMatrix extends JFrame implements KeyListener {

    private JLabel[][] numberLabels;
    private boolean running;

    public RandomNumberMatrix() {
        super("Random Number Matrix");
        setLayout(new GridLayout(10, 10)); // Set layout to a 10x10 grid

        numberLabels = new JLabel[10][10];
        running = true; // Initially start running

        // Initialize labels and add them to the frame
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                numberLabels[i][j] = new JLabel("", JLabel.CENTER);
                numberLabels[i][j].setFont(new Font("Arial", Font.BOLD, 16));
                add(numberLabels[i][j]);
            }
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300); // Set window size to 300x300
        setLocation(0, 0); // Set window position to desktop coordinates 0,0
        setVisible(true);

        addKeyListener(this); // Register key listener for space bar events

        startRandomNumberGeneration();
    }

    private void startRandomNumberGeneration() {
        // Generate random numbers for each label
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int finalI = i;
                int finalJ = j;
                Timer timer = new Timer(0000001, e -> {
                    if (running) {
                        Random random = new Random(); // Each label gets its own Random instance
                        int randomNumber = random.nextInt(100); // Generate a random number between 0 and 99
                        numberLabels[finalI][finalJ].setText(String.valueOf(randomNumber));
                    }
                });
                timer.setInitialDelay(new Random().nextInt(1000)); // Random initial delay up to 1 second
                timer.start();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            running = !running; // Toggle the running state
        }
    }

    // Unused KeyListener methods
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RandomNumberMatrix::new);
    }
}
