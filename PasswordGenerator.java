import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class PasswordGenerator {

    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+<>?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the desired password length: ");
        int length = scanner.nextInt();

        System.out.print("Include uppercase letters? (true/false): ");
        boolean includeUppercase = scanner.nextBoolean();

        System.out.print("Include numbers? (true/false): ");
        boolean includeNumbers = scanner.nextBoolean();

        System.out.print("Include special characters? (true/false): ");
        boolean includeSpecial = scanner.nextBoolean();

        String password = generatePassword(length, includeUppercase, includeNumbers, includeSpecial);
        System.out.println("Generated Password: " + password);
        savePasswordToFile(password);
        System.out.println("Password Strength : " + checkPasswordStrength(password));
        scanner.close();
    }

    public static String generatePassword(int length, boolean includeUppercase, boolean includeNumbers,
            boolean includeSpecial) {
        String characterPool = LOWERCASE;
        if (includeUppercase) {
            characterPool += UPPERCASE;
        }
        if (includeNumbers) {
            characterPool += NUMBERS;
        }
        if (includeSpecial) {
            characterPool += SPECIAL_CHARACTERS;
        }

        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterPool.length()); // Random index selection
            password.append(characterPool.charAt(index)); // Append the selected character
        }

        return password.toString();
    }


  public static void savePasswordToFile(String password) {
        String filePath = "generatedPassword.txt";
        try (FileWriter writer = new FileWriter(filePath, true)) { // Append mode
            writer.write("Generated Password: " + password + "\n");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the password.");
            e.printStackTrace();
        }
    }

   public static String checkPasswordStrength(String password) {
        int score = 0;
        if (password.length() >= 8) score++;
        if (password.matches(".*[A-Z].*")) score++;
        if (password.matches(".*[0-9].*")) score++;
        if (password.matches(".*[!@#$%^&*()-_=+<>?].*")) score++;

        switch (score) {
            case 4: return "Very Strong";
            case 3: return "Strong";
            case 2: return "Moderate";
            default: return "Weak";
        }
    }

}
