import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int allGames = 0;
        int allGuesses = 0;
        int bestGame = 999;
        char goAgain = 'n';

        System.out.print("This program allows you to guess " +
                "random numbers.\nI will think of a random number " +
                "between 1 and 100\nand you will try to guess it.\n" +
                "After each guess, I will give you a clue about\nwhether " +
                "the correct number is higher or lower.\n\n");

        do {

            if (goAgain == 'y') {
                System.out.println();
            }

            int correctAns = generateNum();
            int gameGuesses = guessNum(scan, correctAns);

            allGames++;
            allGuesses += gameGuesses;
            if (gameGuesses < bestGame) {
                bestGame = gameGuesses;
            }
            scan.nextLine(); // buffer flush
            goAgain = playAgain(gameGuesses, scan);

        } while (goAgain == 'y');

        gameStats(allGames, allGuesses, bestGame);

    }

    public static int generateNum() {
        System.out.println("I'm thinking of a number " +
        "between 1 and 100...");
        Random rand = new Random();
        int number = rand.nextInt(100) + 1;
        return number;
    }

    public static int guessNum(Scanner scan, int ans) {
        System.out.print("Your guess? ");
        int guess = scan.nextInt();
        int numGuesses = 1;
        while (guess != ans) {
            if (guess > ans) {
                System.out.println("It's lower.");
            } else {
                System.out.println("It's higher.");
            }
            numGuesses++;
            System.out.print("Your guess? ");
            guess = scan.nextInt();
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
        System.out.printf("\nOverall results:\nTotal games = %d\n" +
        "Total guesses = %d\nGuesses/game = %.1f\nBest game = %d\n",
                nGames, nGuess, (nGuess * 1.0 / nGames), minGuess);
    }
}



