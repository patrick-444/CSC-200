/**
 * @author Patrick Rooney
 * @since September 18, 2025
 * description: Recursive definition of factorial/intro to recursion
 *
 *  0! = 1
 *  n! = n * (n-1) * (n-2) * ... * 1
 *
 *  Function calls build up on the stack, and are popped off the top of the stack according to a
 *  LIFO queue system.
 */

public class recursionIntro {
    public static void main(String[] args) {
        System.out.println(fibonacci(11));
        System.out.println(factorial(20));
    }

    public static long factorial(int n) {
        if (n == 0) {
            return 1; // base case (stopping condition)
        } else {
            return n * factorial(n-1); // recursive call that builds up function calls on the stack
        }
    }

    public static long fibonacci(int n) {
        if (n == 0) { // base case/stopping condition 1
            return 0;
        } else if (n == 1) { // base case/stopping condition 2
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2); // recursive calls to build up stack
        }
    }

    public static String compressString(String input) {
        if (input.length() <= 1) {
            return
        }
    }
}