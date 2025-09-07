/**
 * @author Patrick Rooney
 * @since September 7, 2025
 * description: Ask the user how many courses they are taking, then create 3 arrays to hold information about course name, number
 * of credits, and course grades. Then, calculate the term GPA, and display the output to console. Divide the program into a main
 * method and 3 additional methods.
 */

import java.util.Scanner;

public class Review {
    // main: Use other methods together to get info on semester and write output to console
    public static void main(String[] args) {
        // declare scanner for reading input and get # of classes
        Scanner scan = new Scanner(System.in);
        int nClasses = getClasses(scan);

        // Create arrays to hold number of classes, number of credits per course, and grades for each course
        String[] courseNames = new String[nClasses];
        int[] credits = new int[nClasses];
        double[] grades = new double[nClasses];

        // read in user's grade info
        updateInfo(courseNames, credits, grades, nClasses, scan);

        // calculate GPA and print to output
        calculateGPA(courseNames, credits, grades);
    }

    // Prompt the user for the number of classes they are taking and return input
    public static int getClasses(Scanner scan) {
        System.out.print("How many classes are you taking this semester? ");
        return scan.nextInt();
    }

    // Read in all information for each course
    public static void updateInfo(String[] coursesArray, int[] creditsArray, double[] gradesArray, int nClasses, Scanner scan) {
        for (int i = 0; i < nClasses; i++) {
            System.out.print("Enter course #" + (i + 1) + " name: ");
            scan.nextLine();
            coursesArray[i] = scan.nextLine();
            System.out.print("Enter course #" + (i + 1) + " credit hours: ");
            creditsArray[i] = scan.nextInt();
            System.out.print("Enter course #" + (i + 1) + " grade (out of credit hours, ex: 3.33 / 4.00, enter 3.33): ");
            gradesArray[i] = scan.nextDouble();
        }
    }

    // Calculate the GPA and output the results to console
    public static void calculateGPA(String[] coursesArray, int[] creditsArray, double[] gradesArray) {
        int creditSum = 0;
        double qualityPointsSum = 0;
        System.out.printf("\n%-10s%-10s%-10s%-10s\n", "Class", "Credits", "Grade", "Quality Points");
        for (int i = 0; i < coursesArray.length; i++) {
            double qualityPoints = creditsArray[i] * gradesArray[i];
            System.out.printf("%-10s%-10d%-10.2f%-10.2f\n", coursesArray[i], creditsArray[i], gradesArray[i], qualityPoints);
            creditSum += creditsArray[i];
            qualityPointsSum += qualityPoints;
        }
        System.out.printf("%-25s%-25s%-25s\n", "Total Credits", "TOTAL", "GPA");

        System.out.printf("%-25d%-25.2f%-25.2f\n", creditSum, qualityPointsSum, (4.0 * (qualityPointsSum / (creditSum * 4.0))));
    }
}

/**
 * SAMPLE RUN:
 *
 * How many classes are you taking this semester? 2
 * Enter course #1 name: CSC-200
 * Enter course #1 credit hours: 4
 * Enter course #1 grade (out of credit hours, ex: 3.33 / 4.00, enter 3.33): 3.89
 * Enter course #2 name: MATH-304
 * Enter course #2 credit hours: 4
 * Enter course #2 grade (out of credit hours, ex: 3.33 / 4.00, enter 3.33): 4.00
 *
 * Class     Credits   Grade     Quality Points
 * CSC-200   4         3.89      15.56
 * MATH-304  4         4.00      16.00
 * Total Credits            TOTAL                    GPA
 * 8                        31.56                    3.95
 */