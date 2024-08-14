import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CipherGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Text Encryption");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Text:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        JLabel shiftLabel = new JLabel("Shift:");
        shiftLabel.setBounds(10, 50, 80, 25);
        panel.add(shiftLabel);

        JTextField shiftText = new JTextField(2);
        shiftText.setBounds(100, 50, 165, 25);
        panel.add(shiftText);

        JButton encryptButton = new JButton("Encrypt");
        encryptButton.setBounds(10, 80, 100, 25);
        panel.add(encryptButton);

        JTextField resultText = new JTextField("Output",20);
        resultText.setBounds(10, 110, 255, 25);
        panel.add(resultText);

        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = userText.getText();
                int shift = Integer.parseInt(shiftText.getText());
                resultText.setText(CaesarCipher.encrypt(text, shift));
            }
        });
    }
}
