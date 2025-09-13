/**
 * @author Patrick Rooney
 * @since September 11, 2025
 * description: Application file. Prompt the user for how many classes they are taking, and then calculate
 * their GPA. Use an array of objects instead of parallel arrays for this task.
 */

// package week2; // comment out if necessary
import java.util.Scanner;

public class gpaCalculatorV2 {

    // create an object of courseObjs and calculate GPA
    public static void main(String[] args) {
        // init scanner object for reading input
        Scanner scan = new Scanner(System.in);
        int numClasses = getNumClasses(scan);

        // create array of courseObjs to store course info
        courseObj[] courses = new courseObj[numClasses];

        // fill the array of courseObjs with user specific course info
        fillCoursesArray(courses, scan);

        // display the GPA and course stats in console output
        calculateGPA(courses);

        // close scanner object and terminate main
        scan.close();
    }

    // prompt user for how many classes they are taking and return user input
    public static int getNumClasses(Scanner scan) {
        System.out.println("How many classes are you taking this semester?");
        return Integer.parseInt(scan.nextLine());
    }

    // prompt the user to fill out information for each course
    public static void fillCoursesArray(courseObj[] courses, Scanner scan) {
        for (int i = 0; i < courses.length; i++) {
            System.out.printf("Enter the name of course %d: ", (i + 1));
            String className = scan.nextLine();
            System.out.printf("Enter the number of credits of course %d: ", (i + 1));
            double classCreds = Double.parseDouble(scan.nextLine());
            System.out.printf("Enter the grade for class %d, out of possible credits (ex: 3.33 / 4): ", (i+1));
            double classGrade = Double.parseDouble(scan.nextLine());

            // init courseObj object at index i in courses array using multi-arg constructor
            courses[i] = new courseObj(className, classCreds, classGrade);
        }
    }

    // calculate GPA and write to console output
    public static void calculateGPA(courseObj[] courses) {
        double creditSum = 0.0;
        double qualityPointsSum = 0.0;
        System.out.printf("\n%-10s%-10s%-10s%-10s\n", "Class", "Credits", "Grade", "Quality Points");
        for (courseObj courseName : courses) {
            double qualityPoints = courseName.getCredits() * courseName.getGrade();
            System.out.printf("%-10s%-10.1f%-10.2f%-10.2f\n", courseName.getClassName(), courseName.getCredits(), courseName.getGrade(), qualityPoints);
            creditSum += courseName.getCredits();
            qualityPointsSum += qualityPoints;
        }
        System.out.printf("%-25s%-25s%-25s\n", "Total Credits", "TOTAL", "GPA");

        System.out.printf("%-25.1f%-25.2f%-25.2f\n", creditSum, qualityPointsSum, (4.0 * (qualityPointsSum / (creditSum * 4.0))));
    }
}

/*
SAMPLE RUN 1:

How many classes are you taking this semester?
5
Enter the name of course 1: CSC-200
Enter the number of credits of course 1: 4
Enter the grade for class 1, out of possible credits (ex: 3.33 / 4): 3.5
Enter the name of course 2: CSC-240
Enter the number of credits of course 2: 4
Enter the grade for class 2, out of possible credits (ex: 3.33 / 4): 4.0
Enter the name of course 3: MATH-262
Enter the number of credits of course 3: 3
Enter the grade for class 3, out of possible credits (ex: 3.33 / 4): 3.8
Enter the name of course 4: SSIE 501
Enter the number of credits of course 4: 3
Enter the grade for class 4, out of possible credits (ex: 3.33 / 4): 2.7
Enter the name of course 5: SSIE 660
Enter the number of credits of course 5: 3
Enter the grade for class 5, out of possible credits (ex: 3.33 / 4): 3.85

Class     Credits   Grade     Quality Points
CSC-200   4.0       3.50      14.00
CSC-240   4.0       4.00      16.00
MATH-262  3.0       3.80      11.40
SSIE 501  3.0       2.70      8.10
SSIE 660  3.0       3.85      11.55
Total Credits            TOTAL                    GPA
17.0                     61.05                    3.59

SAMPLE RUN 2

How many classes are you taking this semester?
3
Enter the name of course 1: CSC-240
Enter the number of credits of course 1: 3
Enter the grade for class 1, out of possible credits (ex: 3.33 / 4): 4
Enter the name of course 2: ENG-101
Enter the number of credits of course 2: 1
Enter the grade for class 2, out of possible credits (ex: 3.33 / 4): 4
Enter the name of course 3: MATH-478
Enter the number of credits of course 3: 3.00
Enter the grade for class 3, out of possible credits (ex: 3.33 / 4): 3.00

Class     Credits   Grade     Quality Points
CSC-240   3.0       4.00      12.00
ENG-101   1.0       4.00      4.00
MATH-478  3.0       3.00      9.00
Total Credits            TOTAL                    GPA
7.0                      25.00                    3.57

 */