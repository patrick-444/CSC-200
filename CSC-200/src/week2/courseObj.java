/**
 * @author Patrick Rooney
 * @since September 11, 2025
 * Description: Update the coding assignment from week1 to use an array of objects instead of
 * parallel arrays.
 */

package week2; // comment out if necessary

public class courseObj {
    private String className;
    private double credits;
    private double grade;

    // constructor with args
    courseObj(String className, double credits, double grade) {
        this.className = className;
        this.credits = credits;
        this.grade = grade;
    }

    // default constructor
    courseObj() {
        this.className = "";
        this.grade = 0.0;
        this.credits = 0.0;
    }

    // getter for className attribute
    public String getClassName() {
        return this.className;
    }

    // getter for credits attribute
    public double getCredits() {
        return this.credits;
    }

    // getter for grade attribute
    public double getGrade() {
        return this.grade;
    }

    // setter for className attribute
    public void setClassName(String name) {
        this.className = name;
    }

    // setter for credits attribute
    public void setCredits(double credits) {
        this.credits = credits;
    }

    // setter for grade attribute
    public void setGrade(double grade) {
        this.grade = grade;
    }
}