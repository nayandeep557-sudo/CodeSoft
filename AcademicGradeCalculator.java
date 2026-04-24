import java.util.Scanner;

public class AcademicGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== GRADE CALCULATOR ===");
        System.out.println("Enter marks for 5 subjects:");
        
        double total = 0;
        for (int i = 1; i <= 5; i++) {
            System.out.print("Subject " + i + ": ");
            double mark = sc.nextDouble();
            while (mark < 0 || mark > 100) {
                System.out.print("Invalid! Enter 0-100: ");
                mark = sc.nextDouble();
            }
            total += mark;
        }
        
        double avg = total / 5;
        String grade = getGrade(avg);
        
        System.out.println("\n--- Results ---");
        System.out.println("Total: " + total + "/500");
        System.out.println("Average: " + String.format("%.2f", avg) + "%");
        System.out.println("Grade: " + grade);
        
        sc.close();
    }
    
    public static String getGrade(double avg) {
        if (avg >= 90) return "A+";
        if (avg >= 80) return "A";
        if (avg >= 70) return "B+";
        if (avg >= 60) return "B";
        if (avg >= 50) return "C";
        if (avg >= 40) return "D";
        return "F";
    }
}