/**
 * Created by kapilkrishnakumar on 9/18/15.
 */
import java.util.*;
public class Portmanteau {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for(int z = 0; z < num; z++){
            int wordsNum = sc.nextInt();
            int k = sc.nextInt();

            sc.nextLine();
            String[] words = (sc.nextLine()).split(" ");
//            System.out.println(Arrays.toString(words));
            HashSet<String> result = new HashSet<String>();
            for(int w = 0; w < wordsNum; w++){

                String word1 = words[w];
//                String w2 = words[w + 1];
                int sub = word1.length() - k >= 0 ? word1.length() - k: 0;
//                System.out.println(sub);
              //  String end = word1.substring(sub);
                String end = sub == 0 && sub <= word1.length()? "": word1.substring(sub);


//                System.out.println("w1: "+word1);
                for(int w2 = 0; w2 < wordsNum;w2++){
                    if(w!=w2) {
//                    System.out.println("w2: "+w2);
                        String word2 = words[w2];
//                        System.out.println("word2: " + word2);
//                        int sub2 = k >= word2.length() ? word1.length(): k;

//                        System.out.println(word2.substring(0, ));
                     //   String beg = k >= word2.length() ? word2: word2.substring(0, k);
                        String beg = k >= word2.length() ? "": word2.substring(0, k);
//                        System.out.println("beg: " + beg + " end: " + end);
                        if (end.equals(beg)) {
                            String p = word1 + word2.substring(k);
//                            System.out.println(p);
                            result.add(p);
                        }
                    }
                }
//                System.out.println();

            }
            System.out.println(result.size());
            for(String w: result)
                System.out.println(w);
        }

    }
}
