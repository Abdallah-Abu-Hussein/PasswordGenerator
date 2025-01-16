import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class PasswordGenerator {

    // Constants defining the different character sets used in password generation
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+<>?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = 0;

        while (true) {
            System.out.print("Enter the desired password length: ");
            String input = scanner.nextLine().trim();
            try {
                length = Integer.parseInt(input);
                if (length > 0) {
                    break; // Valid length entered
                } else {
                    System.out.println("Please enter a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        boolean includeUppercase = getBooleanInput(scanner,
                "Include uppercase letters? (press Enter for default true): ");
        boolean includeNumbers = getBooleanInput(scanner, "Include numbers? (press Enter for default true): ");
        boolean includeSpecial = getBooleanInput(scanner,
                "Include special characters? (press Enter for default true): ");

        String password = generatePassword(length, includeUppercase, includeNumbers, includeSpecial);
        System.out.println("Generated Password: " + password);

        String strength = checkPasswordStrength(password);
        System.out.println("Password Strength: " + strength);

        savePasswordToFile(password);

        scanner.close();
    }

    private static boolean getBooleanInput(Scanner scanner, String message) {
        System.out.print(message);
        String input = scanner.nextLine().trim();
        return input.isEmpty() || input.equalsIgnoreCase("true");
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

        // Generate the password by randomly selecting characters from the pool
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterPool.length()); // Random index selection
            password.append(characterPool.charAt(index)); // Append the selected character
        }

        return password.toString(); // Return the generated password
    }

    public static String checkPasswordStrength(String password) {
        int score = 0;
        if (password.length() >= 8)
            score++;
        if (password.matches(".*[A-Z].*"))
            score++;
        if (password.matches(".*[0-9].*"))
            score++;
        if (password.matches(".*[!@#$%^&*()-_=+<>?].*"))
            score++;

        switch (score) {
            case 4:
                return "Very Strong";
            case 3:
                return "Strong";
            case 2:
                return "Moderate";
            default:
                return "Weak";
        }
    }

    public static void savePasswordToFile(String password) {
        String filePath = "generatedPassword.txt";
        try (FileWriter writer = new FileWriter(filePath, true)) { // Append mode
            writer.write("Generated Password: " + password + "\n");
            System.out.println("Password saved to: " + filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the password.");
            e.printStackTrace();
        }
    }
}

