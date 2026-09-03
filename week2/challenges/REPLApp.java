import java.util.Scanner;
import java.util.Random;

public class REPLApp {

    public static void main(String args[]) {
        boolean quitProgram = false;

        System.out.println("Hello Welcome to my REPL App!! :)");
        System.out.println("Type \"help\" for a list of commands (without the quotes)");
        System.out.println("===========================================================");

        Scanner scanner = new Scanner(System.in);

        while (!quitProgram) {
            String input = scanner.nextLine();
            if (input == "") continue;
            switch (input) {
                case "help":
                    help();
                    break;
                case "add":
                    add(scanner);
                    break;
                case "subtract":
                    subtract(scanner);
                    break;
                case "divide":
                    divide(scanner);
                    break;
                case "multiply":
                    multiply(scanner);
                    break;
                case "random":
                    random(scanner);
                    break;
                case "reverse":
                    reverse(scanner);
                    break;
                case "quit":
                    System.out.println("Shutting down, goodbye!");
                    quitProgram = true;
                    break;
                default:
                    System.out.println("Invalid command, try again.. (the help command shows all available options)");
                    break;
            }
        }
    }

    public static void help() {
        System.out.println("Available Commands");
        System.out.println("> help      |   Bring up this menu");
        System.out.println("> add       |   Adds 2 numbers");
        System.out.println("> subtract  |   Subtracts 2 numbers");
        System.out.println("> multiply  |   Multiplies 2 numbers");
        System.out.println("> divide    |   Divides 2 numbers");
        System.out.println("> random    |   Generated a random number within input range");
        System.out.println("> reverse   |   Reverses an input String");
        System.out.println("> quit      |   Exit the program");
        System.out.println("===========================================================");
    }

    public static void add(Scanner scanner) {
        System.out.print("First Number: ");
        int num1 = scanner.nextInt();
        System.out.print("Second Number: ");
        int num2 = scanner.nextInt();
        int result = num1 + num2;
        System.out.println("Result: " + num1 + " + " + num2 + " = " + result);
    }

    public static void subtract(Scanner scanner) {
        System.out.print("First Number: ");
        int num1 = scanner.nextInt();
        System.out.print("Second Number: ");
        int num2 = scanner.nextInt();
        int result = num1 - num2;
        System.out.println("Result: " + num1 + " - " + num2 + " = " + result);
    }

    public static void multiply(Scanner scanner) {
        System.out.print("First Number: ");
        int num1 = scanner.nextInt();
        System.out.print("Second Number: ");
        int num2 = scanner.nextInt();
        int result = num1 * num2;
        System.out.println("Result: " + num1 + " * " + num2 + " = " + result);
    }

    public static void divide(Scanner scanner) {
        System.out.print("First Number: ");
        double num1 = scanner.nextDouble();
        boolean num2isZero = true;
        double num2 = 0;
        while (num2isZero) {
            System.out.print("Second Number: ");
            num2 = scanner.nextDouble();
            if (num2 == 0) {
                System.out.println("ERROR: Cannot divide by 0! Try Again..");
            }
            else { num2isZero = false; }
        }
        double result = num1 / num2;
        System.out.println("Result: " + num1 + " / " + num2 + " = " + result);
    }

    public static void random(Scanner scanner) {
        System.out.print("Minimum: ");
        int num1 = scanner.nextInt();
        System.out.print("Maximum: ");
        int num2 = scanner.nextInt();
        Random rand = new Random();
        int result = rand.nextInt(num1,(num2+1));
        System.out.println("Random Number between " + num1 + " and " + num2 + " (inclusive): " + result);
    }

    public static void reverse(Scanner scanner) {
        System.out.print("Enter text: ");
        String input = scanner.nextLine();
        StringBuilder resultStringBuilder = new StringBuilder();
        resultStringBuilder.append(input);
        resultStringBuilder.reverse();
        System.out.println("Result: " + resultStringBuilder);
    }

    /*
        Hello Welcome to my REPL App!! :)
        Type "help" for a list of commands (without the quotes)
        ===========================================================
        add [input]
        First Number: 4
        Second Number: 4
        Result: 4 + 4 = 8
        subtract [input]
        First Number: 9
        Second Number: 2
        Result: 9 - 2 = 7
        help [input]
        Available Commands
        > help      |   Bring up this menu
        > add       |   Adds 2 numbers
        > subtract  |   Subtracts 2 numbers
        > multiply  |   Multiplies 2 numbers
        > divide    |   Divides 2 numbers
        > random    |   Generated a random number within input range
        > reverse   |   Reverses an input String
        > quit      |   Exit the program
        ===========================================================
        multiply [input]
        First Number: 6
        Second Number: 8
        Result: 6 * 8 = 48
        divide [input]
        First Number: 47
        Second Number: 8
        Result: 47.0 / 8.0 = 5.875
        random [input]
        Minimum: 25
        Maximum: 50
        Random Number between 25 and 50 (inclusive): 50
        random [input]
        Minimum: 10
        Maximum: 100
        Random Number between 10 and 100 (inclusive): 34
        reverse [input]
        Enter text: Testing and Reversing
        Result: gnisreveR dna gnitseT
        quit [input]
        Shutting down, goodbye!
     */
}
