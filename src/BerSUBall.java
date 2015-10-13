import java.util.*;

/**
 * Created by kapilkrishnakumar on 10/7/15.
 * http://codeforces.com/problemset/problem/489/B
 */
public class BerSUBall {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numBoys = sc.nextInt();
        int[] boys = new int[numBoys];
        for(int i = 0; i < numBoys; i++){
            boys[i] = sc.nextInt();
        }

        int numGirls = sc.nextInt();
        int[] girls = new int[numGirls];
        for(int i = 0; i < numGirls; i++){
            girls[i] = sc.nextInt();
        }

        Arrays.sort(boys);
        Arrays.sort(girls);


        int boyIndex = 0;
        int girlIndex = 0;
        int count = 0;
        while (boyIndex < boys.length &&  girlIndex< girls.length) {
            // make sure the difference is more than one
            if (boys[boyIndex] - girls[girlIndex] > 1) {
                // doesnt work, move on the the next girl
                girlIndex++;
            } else if (girls[girlIndex] - boys[boyIndex] > 1){
                // doesnt work, move on to the next boy
                boyIndex++;
            } else {
                count++;
                boyIndex++;
                girlIndex++;

            }
        }
        System.out.println(count);
    }
}
