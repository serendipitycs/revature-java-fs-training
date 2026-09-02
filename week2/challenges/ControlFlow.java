public class ControlFlow {
    public static void main(String[] args) {
        int score = 75;
        //char grade = 'B';

        if (score > 50) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        char assignedGrade;

        if (score >= 90) {
            assignedGrade = 'A';
        } else if (score >= 75 && score <= 89) {
            assignedGrade = 'B';
        } else if (score >= 60 && score <= 74) {
            assignedGrade = 'C';
        } else {
            assignedGrade = 'D';
        }
        System.out.println("Grade = " + assignedGrade);
    }
}
