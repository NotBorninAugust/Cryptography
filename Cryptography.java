
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;


public class Cryptography {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        SecretKey secretKey = generateKey();

        System.out.print("Text to Encrypt: ");
        String userInput = scanner.nextLine();

        String encryptText = encrypt(userInput, secretKey);
        System.out.println("Encrypted Data: " + encryptText);

        String decryptText = decrypt(encryptText, secretKey);
        System.out.println("Decrypted Data to Text: " + decryptText);

        scanner.close();
        
    }
    public static SecretKey generateKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey key = keyGenerator.generateKey();
        return key;
    }
    public static String encrypt(String userInput, SecretKey secretKey) throws Exception{

        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = c.doFinal(userInput.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);

    }
    public static String decrypt(String encryptText, SecretKey secretKey) throws Exception{

        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptText);
        byte[] decryptedBytes = c.doFinal(decodedBytes);
        return new String(decryptedBytes);
        

    }
}