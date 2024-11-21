
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EncryptGUI {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Encrypt and Decrypt");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(null);

        JLabel word = new JLabel("Enter Word: ");
        word.setBounds(50, 30, 150, 15);
        frame.add(word);

        JLabel shift = new JLabel("Enter Shift: ");
        shift.setBounds(50, 80, 150, 15);
        frame.add(shift);


        JTextField textField = new JTextField();
        textField.setBounds(50, 50, 110, 20);
        frame.add(textField);

        JTextField shiftField = new JTextField();
        shiftField.setBounds(50, 100, 110, 20);
        frame.add(shiftField);


        JButton encryptButton = new JButton("Encrypt Text");
        encryptButton.setBounds(180, 50, 120, 20);
        frame.add(encryptButton);

        JButton decryptButton = new JButton("Decrypt Text");
        decryptButton.setBounds(180, 100, 120, 20);
        frame.add(decryptButton);
        

        frame.setVisible(true);
        encryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String input = textField.getText();
                int shift = Integer.parseInt(shiftField.getText());
                String encrypted = encrypt(input, shift);
                textField.setText(encrypted);
                System.out.println("Encrypted: " + encrypted);
            }
            
        });
        decryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String input = textField.getText();
                int shift = Integer.parseInt(shiftField.getText());
                String decrypted = decrypt(input, shift);
                textField.setText(decrypted);
                System.out.println("Decrypted: " + decrypted);

            }
        });

    }
    public static String encrypt(String input, int shift){
        char charWord = ' ';
        String encrptyWord = "";
        int i = 0;

        while(i < input.length()){
            charWord = input.charAt(i);

            int ascii = (int) charWord;
            int shiftAscii = ascii + shift;

            encrptyWord += Character.toString(shiftAscii);
            i++;
        }
        return encrptyWord;
    }
    public static String decrypt(String input, int shift){
        return encrypt(input, - shift);
    }
}
