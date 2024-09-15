import java.util.Scanner;
import java.util.ArrayList;


public class StudentGrades {
    public static double calculateAverage(ArrayList<Double> grades) {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }


    public static double findLowest(ArrayList<Double> grades) {
        double lowest = Double.MAX_VALUE;
        for (double grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }


    public static double findHighest(ArrayList<Double> grades) {
        double highest = Double.MIN_VALUE;
        for (double grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int choice;
        
        do{
            System.out.print("Enter the Number of students : ");
            int numStudents = sc.nextInt();
            
            ArrayList<Double> grades = new ArrayList<>();
            
            for (int i = 1; i <= numStudents; i++) {
                System.out.print("Enter the grade for student " + (i) + ": ");
                double grade = sc.nextDouble();
                grades.add(grade);
            }
            
            double average = calculateAverage(grades);
            double highest = findHighest(grades);
            double lowest = findLowest(grades);
            
            System.out.println("Average grade: " + average);
            System.out.println("Highest grade: " + highest);
            System.out.println("Lowest grade: " + lowest);
           
            System.out.println("To perform the calculation again press 1 : to exit press 0");
            choice=sc.nextInt();
        }
         while(choice==1);
    }
}
