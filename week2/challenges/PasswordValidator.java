import java.util.Locale;
import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        boolean validPassword = false;
        StringBuilder missingRequirements = new StringBuilder();

        while (!validPassword) {
            validPassword = true;
            missingRequirements = new StringBuilder();
            System.out.println("Please enter a password:");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            //check length
            if (input.length() < 8) {
                missingRequirements.append("- must include minimum 8 characters\n");
                validPassword = false;
            }
            //check if contains uppercase
            //If the raw input and all lowercase version of input are the same, then there's no uppercase
            if (input.toLowerCase(Locale.ROOT) == input) {
                missingRequirements.append("- must include a capital letter\n");
                validPassword = false;
            }
            //check if contains lowercase
            //If the raw input and all uppercase version of input are the same, then there's no lowercase
            if (input.toUpperCase(Locale.ROOT) == input) {
                missingRequirements.append("- must include a lowercase letter\n");
                validPassword = false;
            }
            //check if contains a number
            if (!input.matches(".*\\d.*")) {
                missingRequirements.append("- must include a number\n");
                validPassword = false;
            }

            if (!validPassword) {
                System.out.println("Password Rejected:\n" + missingRequirements);
                System.out.println("Please try again..");
            }
        }
        System.out.println("Password Accept, shutting down program.");
    }
    /*
        Please enter a password:
        testing [input]
        Password Rejected:
        - must include minimum 8 characters
        - must include a capital letter
        - must include a number

        Please try again..
        Please enter a password:
        HI123 [input]
        Password Rejected:
        - must include minimum 8 characters
        - must include a lowercase letter

        Please try again..
        Please enter a password:
        THEBESTpass [input]
        Password Rejected:
        - must include a number

        Please try again..
        Please enter a password:
        H0w4b0UtNoW [input]
        Password Accept, shutting down program.
    */
}
