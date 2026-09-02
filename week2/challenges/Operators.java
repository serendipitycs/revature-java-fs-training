public class Operators {
    public static void main(String[] args) {
        int a = 20;
        int b = 10;

        //Add
        int additionResult = a + b;
        System.out.println("Add: A + B = " + additionResult);

        //Subtract
        int subtractionResult = a - b;
        System.out.println("Subtract: A - B = " + subtractionResult);

        //Multiply
        int multiplicationResult = a * b;
        System.out.println("Multiply: A * B = " + multiplicationResult);

        //Divide
        int divisionResult = a / b;
        System.out.println("Divide A / B = " + divisionResult);

        //Compare
        boolean greaterThan = (a > b);
        System.out.println("Is A greater than B = " + greaterThan);

        //Compare with AND
        boolean greaterThanAndGreaterThanZero = (a > b) && (b > 0);
        System.out.println("Is A greater than B AND is B greater than 0 = " + greaterThanAndGreaterThanZero);
    }
}
