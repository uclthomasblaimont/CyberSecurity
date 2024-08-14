import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VigenereCipherGUI {

    public static void main(String[] args) {
        // Créer le cadre principal
        JFrame frame = new JFrame("Vigenère Cipher");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Créer les labels
        JLabel textLabel = new JLabel("Text:");
        textLabel.setBounds(50, 50, 100, 25);
        frame.add(textLabel);

        JLabel keyLabel = new JLabel("Key:");
        keyLabel.setBounds(50, 100, 100, 25);
        frame.add(keyLabel);

        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(50, 200, 100, 25);
        frame.add(resultLabel);

        // Créer les champs de texte
        JTextField textField = new JTextField();
        textField.setBounds(150, 50, 300, 25);
        frame.add(textField);

        JTextField keyField = new JTextField();
        keyField.setBounds(150, 100, 300, 25);
        frame.add(keyField);

        JTextField resultField = new JTextField();
        resultField.setBounds(150, 200, 300, 25);
        resultField.setEditable(false);
        frame.add(resultField);

        // Créer les boutons
        JButton encryptButton = new JButton("Encrypt");
        encryptButton.setBounds(150, 150, 100, 25);
        frame.add(encryptButton);

        JButton decryptButton = new JButton("Decrypt");
        decryptButton.setBounds(300, 150, 100, 25);
        frame.add(decryptButton);

        // Ajouter l'action pour le bouton Encrypt
        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                String key = keyField.getText();
                String encryptedText = VigenereCipher.encrypt(text, key);
                resultField.setText(encryptedText);
            }
        });

        // Ajouter l'action pour le bouton Decrypt
        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                String key = keyField.getText();
                String decryptedText = VigenereCipher.decrypt(text, key);
                resultField.setText(decryptedText);
            }
        });

        // Rendre la fenêtre visible
        frame.setVisible(true);
    }
}
