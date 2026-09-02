import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Arrays;

public class TestScoreCalc {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int[] inputVals = new int[5];

        //Initial Input Loop
        for (int i = 0; i < inputVals.length; i++){
            System.out.println("Please enter score #" + (i+1) + ": ");
            inputVals[i] = scanner.nextInt();
        }

        //Performing aggregate calculations on the inputs (stored in array) using java.util.Arrays streams
        System.out.println();
        System.out.println("Total | " + Arrays.stream(inputVals).sum());
        System.out.println("Average | " + Arrays.stream(inputVals).average().getAsDouble());
        System.out.println("Highest | " + Arrays.stream(inputVals).max().getAsInt());
        System.out.println("Lowest | " + Arrays.stream(inputVals).min().getAsInt());

        System.out.println("Your scores were:");
        for (int i = 0; i < inputVals.length; i++) {
            System.out.println(inputVals[i] + " -- " + calculateGrade(inputVals[i]));
        }
        scanner.close();
    }

    //Simple class to calculate grade accoring to input param (score)
    private static char calculateGrade (int score) {
        return
            (score >= 90) ? 'A' :
            (score >= 80) ? 'B' :
            (score >= 70) ? 'C' :
            (score >= 60) ? 'D' :
            'F';
    }

    /* === EXAMPLE I/O ===
        Please enter score #1:
        82
        Please enter score #2:
        94
        Please enter score #3:
        99
        Please enter score #4:
        25
        Please enter score #5:
        67

        Total | 367
        Average | 73.4
        Highest | 99
        Lowest | 25
        Your scores were:
        82 -- B
        94 -- A
        99 -- A
        25 -- F
        67 -- D
    */
}
