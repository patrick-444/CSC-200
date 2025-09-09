import java.util.Random;
import java.util.Scanner;

public class GuessingGame2 {

    private static final int MAX_VAL = 100;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Random rand = new Random();              //declare only one Random object



        printIntro("""
                This program allows you to guess random numbers.
                I will think of a number between 1 and 100
                and you will try to guess it.
                After each guess, I will give you a clue about
                whether the correct number is higher or lower.
                """);

        System.out.println("I'm thinking of a number between 1 and 100...");
        int numToGuess = rand.nextInt(MAX_VAL) + 1;

        runGame( numToGuess);



    }

    private static int runGame(int numToGuess) {

        int guess = 0;
        int count = 0;
        do{
            System.out.print("Your guess? ");
            guess = scanner.nextInt();
            ++count;

            if( guess < numToGuess){
                System.out.println("It's higher. ");
            }else if( guess > numToGuess){
                System.out.println("It's lower. ");
            }
        }while(guess !=numToGuess);

        return count;
    }

    private static void printIntro(String msg) {

        System.out.println(msg);

    }


}