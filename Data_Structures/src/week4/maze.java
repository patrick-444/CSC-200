import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class maze{

    static int startRowIndex;
    static int startColIndex;

    public static void main(String[] args) {

        String fileName = "maze.txt";
        char[][] map = readMapFile(fileName);
        printMap(map);

    }

    private static char[][] readMapFile(String fileName) {
        Scanner inFile = null;

        try {
            inFile = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("Bad file name");
            e.printStackTrace();
            System.exit(1);
        }

        int numRows = inFile.nextInt();
        int numCols = inFile.nextInt();

        char[][] map = new char[numRows][numCols];

        startRowIndex = inFile.nextInt();
        startColIndex = inFile.nextInt();

        inFile.nextLine(); // buffer flush

        int row = 0; // row index
        while(inFile.hasNext()) { // keep reading the input
            String line = inFile.next(); // next line of the maze

            // read each character in the line
            for (int col = 0; col < line.length(); col++) {
                char ch = line.charAt(col);
                map[row][col] = ch;
            }
            row++; // move to the next row
        }

        return map;
    }

    public static void printMap(char[][] map) {
        for(int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[r].length; c++) {
                System.out.print(map[r][c]);
            }
            System.out.println();
        }
    }

}