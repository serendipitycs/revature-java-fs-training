public class Calculator {
    public static void main(String[] args) {
        double num1 = 5;
        double num2 = 9;
        char operator = '*';
        double result = 0;

        String again = "Y";
        while (again == "Y"){
            if (operator == '+'){
                result = num1 + num2;
            } else if (operator == '-') {
                result = num1 - num2;
            } else if (operator == '*') {
                result = num1 * num2;
            } else if (operator == '/') {
                if (num2 == 0) {
                    System.out.println("Cannot divide by zero");
                } else {
                    result = num1 / num2;
                }
            }
            System.out.println("Result = " + result);
            again = "N";
        }
        System.out.println("Thank you for using the calculator.");
    }
}
