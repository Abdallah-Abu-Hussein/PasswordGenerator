# Password Generator
[Video Link](https://youtu.be/264usbLaZjk)
## Overview
This project is a simple Java-based **Password Generator** that allows users to generate secure passwords based on customizable preferences. It includes additional features such as password strength evaluation and saving generated passwords to a file.

---

## Features
- **Customizable Password Generation:**
  - Define the password length.
  - Include or exclude uppercase letters, numbers, and special characters.
- **Password Strength Checker:**
  - Evaluates the generated password and rates it as Weak, Moderate, Strong, or Very Strong.
- **Save Passwords:**
  - Appends generated passwords to a file named `generatedPassword.txt` for record-keeping.
- **Input Validation:**
  - Ensures the password length is a positive integer.

---

## How to Run
1. **Clone the Repository:**
   ```bash
   git clone <repository-url>
   cd <repository-directory>
   ```

2. **Compile the Java Code:**
   ```bash
   javac PasswordGenerator.java
   ```

3. **Run the Application:**
   ```bash
   java PasswordGenerator
   ```

---

## User Guide
### Input Prompts:
1. **Password Length:**
   - Enter a positive number for the desired password length.
2. **Character Preferences:**
   - Press **Enter** to accept the default (`true`), or type `true/false` to specify preferences for:
     - Uppercase letters
     - Numbers
     - Special characters

### Output:
- The application will display the generated password and its strength.
- Passwords will be saved to `generatedPassword.txt` in the same directory.

---

## Example Output
```
Enter the desired password length: 12
Include uppercase letters? (press Enter for default true):
Include numbers? (press Enter for default true): false
Include special characters? (press Enter for default true):
Generated Password: abcdefghJKL@
Password Strength: Strong
Password saved to: generatedPassword.txt
```

---

## File Details
- **`PasswordGenerator.java`**: Main program file containing all the logic for generating passwords, checking strength, and saving passwords.
- **`generatedPassword.txt`**: Output file where all generated passwords are saved.

---

## Future Improvements
- Add support for loading configuration from a file.
- Implement additional password strength metrics.
- Create a GUI version for better user experience.

---

## License
This project is licensed under the MIT License. See the LICENSE file for details.


