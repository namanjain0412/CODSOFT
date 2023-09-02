import  java.util.Scanner;
import java.text.DecimalFormat;
public class Task2 {
    public static void main(String args[]) {
    /*  Input: Take marks obtained (out of 100) in each subject.
        Calculate Total Marks: Sum up the marks obtained in all subjects.
        Calculate Average Percentage: Divide the total marks by the total number of subjects to get the
        average percentage.
        Grade Calculation: Assign grades based on the average percentage achieved.
        Display Results: Show the total marks, average percentage, and the corresponding grade to the user   */
        
        Scanner scanner = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        int total = 0;
        int subjectIndex = 1;
        System.out.println("Enter marks of each subject (out of 100 for a total of 6 subjects) below to calculate total,average and grade");
        while(subjectIndex<=6) {
            int marks = 0;
            System.out.print("\nEnter subject "+subjectIndex+" marks :");
            try {
                marks = Integer.parseInt(scanner.nextLine());
            } catch(Exception e) {
                System.out.println("Bad Input, please enter numericals only");
                continue;
            }
            if(marks>=0 && marks <=100) {
                total += marks;
                subjectIndex++;
            } else {
                System.out.println("Bad Input, marks should only be entered between 1 - 100");
            }
        }
        double avgpercentage = (double)total/6;
        System.out.println("\nTotal : "+total+"/600\nAverage Percentage : "+decimalFormat.format(avgpercentage)+"\nGrade :"+getGrade(avgpercentage));

    }

    public static String getGrade(double percentage) {
        if(percentage>=95) {
            return "A+";
        } else if(percentage>=85) {
            return "A";
        } else if(percentage>=70) {
            return "B";
        } else if(percentage>=60) {
            return "C";
        } else if(percentage>=50) {
            return "D";
        } else if(percentage>=35) {
            return "E";
        }
        return "F";
    }

}
