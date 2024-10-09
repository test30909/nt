import java.util.Scanner;

public class CaesarCipher {

    public static String encrypt(String message, int shift) {
        StringBuilder encrypted = new StringBuilder();

        for (char character : message.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                char encryptedChar = (char) ((character - base + shift) % 26 + base);
                encrypted.append(encryptedChar);
            } else {
                encrypted.append(character);
            }
        }

        return encrypted.toString();
    }

    public static String decrypt(String message, int shift) {
        return encrypt(message, 26 - (shift % 26));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the message: ");
        String message = scanner.nextLine();

        System.out.print("Enter the shift value (0-25): ");
        int shift = scanner.nextInt();

        String encryptedMessage = encrypt(message, shift);
        System.out.println("Encrypted Message: " + encryptedMessage);

        String decryptedMessage = decrypt(encryptedMessage, shift);
        System.out.println("Decrypted Message: " + decryptedMessage);

        scanner.close();
    }
}
