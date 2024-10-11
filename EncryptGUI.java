
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class EncryptGUI {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Encrypt and Decrypt");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        JTextField textField = new JTextField(25);

        JButton encryptButton = new JButton("Encrypt Text");
        JButton decryptButton = new JButton("Decrypt Text");

        encryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String input = textField.getText();
                String encrypted = encrypt(input, 3);
                textField.setText(encrypted);
                System.out.println("Encrypted: " + encrypted);
            }
            
        });

        decryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String input = textField.getText();
                String decrypted = decrypt(input, 3);
                textField.setText(decrypted);
                System.out.println("Decrypted: " + decrypted);

            }
        });


        frame.add(textField);
        frame.add(encryptButton);
        frame.add(decryptButton);

        frame.setVisible(true);

    }
    public static String encrypt(String input, int shift){
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                result.append((char) ((c - base + shift) % 26 + base));
            } else {
                result.append(c); // Keep non-letters unchanged
            }
        } 
        return result.toString();       

    }
    public static String decrypt(String input, int shift){

        return encrypt(input, 26 - shift);

    }
}
