import java.util.Scanner;
import java.util.InputMismatchException;

public class Student {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Marks (out of 100): ");
            int marks = sc.nextInt();

            if (marks < 0 || marks > 100) {
                throw new IllegalArgumentException("Marks must be between 0 and 100.");
            }

            String grade;

            if (marks >= 90)
                grade = "A";
            else if (marks >= 75)
                grade = "B";
            else if (marks >= 60)
                grade = "C";
            else if (marks >= 40)
                grade = "D";
            else
                grade = "Fail";

            System.out.println("\n--- Student Result ---");
            System.out.println("Student Name : " + name);
            System.out.println("Marks Entered: " + marks);
            System.out.println("Grade Obtained: " + grade);
        }

        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter numeric marks only.");
        }

        finally {
            System.out.println("Marks evaluation completed.");
        }

        sc.close();
    }
}
