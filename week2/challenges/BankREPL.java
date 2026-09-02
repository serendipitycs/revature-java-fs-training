import java.util.Scanner;

public class BankREPL {
    public static void main(String[] args) {
        boolean exitProgram = false;
        double balance = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to REPL Bank! Please Select an option:");
        //Main REPL Loop
        while (!exitProgram) {
            System.out.println("=========================");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit the program");
            System.out.println("=========================");
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Check Balance - Selected");
                    System.out.printf("Current Balance is | $%.2f", balance);
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Deposit Money - Selected");
                    System.out.print("How much to deposit? : $");
                    double inputAmtDeposit = scanner.nextDouble();
                    if (inputAmtDeposit > 0) {
                        balance += inputAmtDeposit;
                        System.out.printf("You deposited $%.2f", inputAmtDeposit);
                        System.out.println();
                        System.out.printf("Current Balance is | $%.2f", balance);
                        System.out.println();
                    } else {
                        System.out.println("Deposit amount must be a value greater than 0!");
                    }
                    break;
                case 3:
                    System.out.println("Withdraw Money - Selected");
                    System.out.print("How much to withdraw? : $");
                    double inputAmtWithdraw = scanner.nextDouble();
                    if (inputAmtWithdraw > 0) {
                        if (balance - inputAmtWithdraw > 0) {
                            balance -= inputAmtWithdraw;
                            System.out.printf("You withdrew $%.2f", inputAmtWithdraw);
                            System.out.println();
                            System.out.printf("Current Balance is | $%.2f", balance);
                            System.out.println();
                        } else {
                            System.out.println("Cancelling withdrawl, balance cannot go below $0.00");
                        }
                    } else {
                        System.out.println("Withdraw amount must be a value greater than 0!");
                    }
                    break;
                case 4:
                    exitProgram = true;
                    System.out.println("Exiting the program, Thank you for banking with us!");
                    break;
                default:
                    System.out.println("Invalid option, please try again...");
                    break;
            }
        }
    }
    /*
        Welcome to REPL Bank! Please Select an option:
        =========================
        1. Check Balance
        2. Deposit Money
        3. Withdraw Money
        4. Exit the program
        =========================
        1 [input]
        Check Balance - Selected
        Current Balance is | $0.00
        =========================
        1. Check Balance
        2. Deposit Money
        3. Withdraw Money
        4. Exit the program
        =========================
        2 [input]
        Deposit Money - Selected
        How much to deposit? : $45.54
        You deposited $45.54
        Current Balance is | $45.54
        =========================
        1. Check Balance
        2. Deposit Money
        3. Withdraw Money
        4. Exit the program
        =========================
        3 [input]
        Withdraw Money - Selected
        How much to withdraw? : $90.33
        Cancelling withdrawl, balance cannot go below $0.00
        =========================
        1. Check Balance
        2. Deposit Money
        3. Withdraw Money
        4. Exit the program
        =========================
        3 [input]
        Withdraw Money - Selected
        How much to withdraw? : $20.02
        You withdrew $20.02
        Current Balance is | $25.52
        =========================
        1. Check Balance
        2. Deposit Money
        3. Withdraw Money
        4. Exit the program
        =========================
        4 [input]
        Exiting the program, Thank you for banking with us!
     */
}
