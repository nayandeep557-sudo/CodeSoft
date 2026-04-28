import java.util.Scanner;

public class GradeCalculator {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("========================================");
        System.out.println("     STUDENT GRADE CALCULATOR");
        System.out.println("========================================");
        
        // Get number of subjects
        System.out.print("Enter number of subjects: ");
        int numSubjects = scanner.nextInt();
        
        double[] marks = new double[numSubjects];
        
        // Get marks for each subject
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextDouble();
        }
        
        // Calculate total marks
        double totalMarks = calculateTotal(marks);
        
        // Calculate average percentage
        double average = calculateAverage(totalMarks, numSubjects);
        
        // Get grade
        String grade = getGrade(average);
        
        // Display results
        System.out.println("\n========================================");
        System.out.println("            RESULTS");
        System.out.println("========================================");
        System.out.printf("Total Marks           : %.2f / %d\n", totalMarks, numSubjects * 100);
        System.out.printf("Average Percentage    : %.2f%%\n", average);
        System.out.println("Grade                 : " + grade);
        System.out.println("========================================");
        
        scanner.close();
    }
    
    public static double calculateTotal(double[] marks) {
        double total = 0;
        for (double mark : marks) {
            total += mark;
        }
        return total;
    }
    
    public static double calculateAverage(double total, int count) {
        return total / count;
    }
    
    public static String getGrade(double average) {
        if (average >= 90) {
            return "A+";
        } else if (average >= 80) {
            return "A";
        } else if (average >= 70) {
            return "B+";
        } else if (average >= 60) {
            return "B";
        } else if (average >= 50) {
            return "C";
        } else if (average >= 40) {
            return "D";
        } else {
            return "F";
        }
    }
}