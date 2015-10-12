import java.util.*;

/**
 * Created by kapilkrishnakumar on 10/2/15.
 */
public class ICPC3 {

    public static void main(String[] main) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int test = 1; test < n ; test++){
            int fX = sc.nextInt();
            int fY = sc.nextInt();
            Point f = new Point(fX, fY);
            int sX = sc.nextInt();
            int sY = sc.nextInt();
            Point s = new Point(sX, sY);
            int numAst = sc.nextInt();

            HashSet<Point> asts = new HashSet<Point>();
            for(int ast = 0; ast < numAst; ast++){
                int astX = sc.nextInt();
                int astY = sc.nextInt();
                Point astVal = new Point(astX, astY);
                asts.add(astVal);
            }
//            int a = Integer.MIN_VALUE
//            Point current =
        }
    }


    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
