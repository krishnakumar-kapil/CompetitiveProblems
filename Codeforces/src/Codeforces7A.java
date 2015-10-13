import java.util.*;

/**
 * Created by kapilkrishnakumar on 9/19/15.
 */
public class Codeforces7A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] board = new char[8][8];
        for(int r = 0; r < 8; r++){
            String line = sc.nextLine();
            for(int c = 0; c < 8; c++){
                board[r][c] = line.charAt(c);
            }
        }
    }
}
