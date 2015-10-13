import java.util.Scanner;

/**
 * Created by Rohit on 9/18/15.
 */
public class Keyboard {


    public static void main(String[] args) {
        char[][] keyboard = new char[][]{
                {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P'},
                {'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', ';'},
                {'Z', 'X', 'C', 'V', 'B', 'N', 'M', ',', '.', '/'}};
        Scanner sc = new Scanner(System.in);
        int numWords = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numWords; i++) {
            String word = sc.nextLine();
            int distance = 0;
            char previousChar = '1';
            int[] previousCoords = getCharCoordinates(word.charAt(0), keyboard);
            for (int j = 0; j < word.length(); j++) {
                char charAtPos = word.charAt(j);
                int[] currentCoords;
                if (previousChar != '1') {
                    currentCoords = getCharCoordinates(charAtPos, keyboard);

                    distance += Math.abs(currentCoords[0] - previousCoords[0]);
                    distance += Math.abs(currentCoords[1] - previousCoords[1]);
                    previousCoords[0] = currentCoords[0];
                    previousCoords[1] = currentCoords[1];
                }
                previousChar = charAtPos;
            }
            System.out.println(distance);
        }
    }

    public static int[] getCharCoordinates(char c, char[][] keyboard) {
        for (int row = 0; row < keyboard.length; row++) {
            for (int col = 0; col < keyboard[0].length; col++) {
                if (keyboard[row][col] == c)
                    return new int[]{row, col};
            }
        }
        return null;
    }
}
