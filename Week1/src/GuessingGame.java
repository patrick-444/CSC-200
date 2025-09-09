import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static final int MAXIMUM_NUMBER = 100; // class constant for upper bound
    public static final Random rand = new Random(); // class level random var

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int allGames = 0;
        int allGuesses = 0;
        int bestGame = 999;
        char goAgain = 'n';

        System.out.print("This program allows you to guess " +
                "random numbers.\nI will think of a number " +
                "between 1 and " + MAXIMUM_NUMBER + "\nand you will try to guess it.\n" +
                "After each guess, I will give you a clue about\nwhether " +
                "the correct number is higher or lower.\n\n");

        do {

            if (goAgain == 'y') {
                System.out.println();
            }

            int correctAns = generateNum(rand);
            int gameGuesses = guessNum(scan, correctAns);

            allGames++;
            allGuesses += gameGuesses;
            if (gameGuesses < bestGame) {
                bestGame = gameGuesses;
            }
            // scan.nextLine(); // buffer flush
            goAgain = playAgain(gameGuesses, scan);

        } while (goAgain == 'y');

        gameStats(allGames, allGuesses, bestGame);

    }

    public static int generateNum(Random rand) {
        System.out.println("I'm thinking of a number " +
        "between 1 and " + MAXIMUM_NUMBER + "...");
        int number = rand.nextInt(MAXIMUM_NUMBER) + 1;
        return number;
    }

    public static int guessNum(Scanner scan, int ans) {
        System.out.print("Your guess? ");
        int guess = scan.nextInt();
        scan.nextLine(); // buffer flush
        int numGuesses = 1;
        while (guess != ans) {
            if (guess > ans) {
                System.out.println("It's lower.");
            } else {
                System.out.println("It's higher.");
            }
            numGuesses++;
            System.out.print("Your guess? ");
            guess = Integer.parseInt(scan.nextLine());
            // scan.nextLine(); // buffer flush
        }
        return numGuesses;
    }

    public static char playAgain(int tries, Scanner scan) {
        System.out.printf("You got it right in %d guesses!\n", tries);
        System.out.print("Do you want to play again? ");
        char again = Character.toLowerCase(scan.nextLine().charAt(0));

        return again;
    }

    public static void gameStats(int nGames, int nGuess, int minGuess) {

        System.out.print("Overall results:\n");
        System.out.printf("Total games   = %d\n", nGames);
        System.out.printf("Total guesses = %d\n", nGuess);
        System.out.printf("Guesses/game  = %.1f\n", (nGuess * 1.0 / nGames));
        System.out.printf("Best game     = %d\n", minGuess);

    }
}


/*
PROFESSOR FEEDBACK

So ... part 1 is to fix the "logic" ... you state that the guess is too low or too high, but they want
 you to state the goal number is lower or higher.  (i.e. change the text "lower" and "higher")
Then you need to prompt to play again and repeat.  (Notice I changed the Scanner variable to be a class
 data field.  (some environments have issues creating more than 1)  Here is the updated code  ...

REVISED CODE FOR GETTING GUESSES

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

 */