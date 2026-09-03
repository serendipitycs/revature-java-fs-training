import java.util.Scanner;

public class WordAnalyzer {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter any string to be analyzed:");
        String input = scanner.nextLine();

        int inputLength = input.length();
        int vowelCount = 0;
        int consonantsCount = 0;
        int digitsCount = 0;
        int spacesCounter = 0;

        for (char c : input.toCharArray()) {
            String character = Character.toString(c);
            //is a letter check
            if (character.matches("[a-zA-Z]")) {
                if ("aeiou".contains(character)) {
                    vowelCount++;
                }
                else {
                    consonantsCount++;
                }
            //is a digit check
            } else if (character.matches("\\d")) {
                digitsCount++;
            //is a space check
            } else if (character.matches("\\s")) {
                spacesCounter++;
            }
        }

        System.out.println("Characters  | " + inputLength);
        System.out.println("Vowels      | " + vowelCount);
        System.out.println("Consonants  | " + consonantsCount);
        System.out.println("Digits      | " + digitsCount);
        System.out.println("Spaces      | " + spacesCounter);
    }
    /*
        Please enter any string to be analyzed:
        Hello this is a message 234 [input]
        Characters  | 27
        Vowels      | 8
        Consonants  | 11
        Digits      | 3
        Spaces      | 5
     */
}
