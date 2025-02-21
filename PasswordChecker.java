import java.util.Scanner;
/**
 * This is a very very simple implementation of a password strength checker that give a score to a 
 * password inputted by the user.
 * @Author: Marisa Nieto Del Rio De Astis u1406293
 * @Date Last Modified: 02/20/2025
 */
public class PasswordChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a password:");
        String password = scanner.nextLine();
        
        if(password.isEmpty()){
            System.out.println("Please enter a valid password");
        }else{

            int score = checkPasswordStrength(password);

            if (score <= 2) {
                System.out.println("Weak password." + " Your password score was " + score);
            } else if (score == 3) {
                System.out.println("Moderate password." + " Your password score was " + score);
            } else {
                System.out.println("Strong password." + " Your password score was " + score);
            }

        }

        scanner.close();
    }

    public static int checkPasswordStrength(String password) {
        int score = 0;


        //the longer the password the better the strength
        if (password.length() >= 8) {
            score += password.length() % 2;
        }

        //REGEX for uppercase character
        if (password.matches(".*[A-Z].*")) {
            score++; 
        }

        //REGEX for lower case character
        if (password.matches(".*[a-z].*")) {
            score++; 
        }

        //REGEX for a number 
        if (password.matches(".*[0-9].*")) {
            score++; 
        }

        //if a password contains a special character
        if (password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            score++; 
        }

        return score;
    }
}
