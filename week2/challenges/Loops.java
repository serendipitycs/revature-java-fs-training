public class Loops {
    public static void main(String[] args) {
        System.out.print("For Loop:");
        for (int i = 0; i < 5; i++){
            System.out.print(" " + (i+1));
        }
        System.out.println();

        System.out.print("While Loop:");
        int whileCounter = 1;
        while (whileCounter <= 5){
            System.out.print(" " + whileCounter);
            whileCounter++;
        }
        System.out.println();

        System.out.print("Do While Loop:");
        int doWhileCounter = 1;
        do {
            System.out.print(" " + doWhileCounter);
            doWhileCounter++;
        } while (doWhileCounter <= 5);
    }
}
