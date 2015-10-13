import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

/**
 * Created by kapilkrishnakumar on 4/24/15.
 */
public class p3 {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int numTests = s.nextInt();
        while (numTests > 0) {
            int nmBalls = s.nextInt();
            Scanner l = new Scanner(s.nextLine());
            int[] a = new int[nmBalls];
            int i = 0;
            while (l.hasNextInt()) {
                int k = l.nextInt();
                a[i] =k;
                System.out.println(k);
                i++;
            }
            System.out.println(Arrays.toString(a));
            double size = a[0];

            for(int j = 0; j < nmBalls - 1;j++){

                double h = a[j+1] - a[j];
                double hyp = a[j+1] + a[j];
                double width = Math.sqrt(hyp*hyp - h*h);
            }
            size += a[nmBalls - 1];

            System.out.println((int)Math.ceil(size));
            numTests--;
        }
    }
}
