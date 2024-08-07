import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RandomNumberGenerator extends JFrame {

    private JLabel randomNumberLabel;

    public RandomNumberGenerator() {
        super("Random Number Generator");
        randomNumberLabel = new JLabel("", JLabel.CENTER);
        randomNumberLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(randomNumberLabel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);

        generateRandomNumber();
    }

    private void generateRandomNumber() {
        Timer timer = new Timer(1000, e -> {
            Random random = new Random();
            int randomNumber = random.nextInt(100); // Generate a random number between 0 and 99
            randomNumberLabel.setText(String.valueOf(randomNumber));
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RandomNumberGenerator::new);
    }
}
