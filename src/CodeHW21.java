/**
 * Created by kapilkrishnakumar on 9/8/15.
 */
import java.util.*;

public class CodeHW21 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        for(int i = 0; i <= word.length(); i++){
            for(int ch = 'a'; ch < 'z' + 1; ch++){
//                System.out.println(word +" pos"+i +" ch:"+ch);
                StringBuilder temp = new StringBuilder(word.substring(0,i));
                String cha = "" +(char)ch;
//                System.out.println(cha);
                temp.append(cha);
                temp.append(word.substring(i));
                String init = temp.toString();
                String reverse = temp.reverse().toString();
//                System.out.println(reverse);
                if(reverse.equals(init)){
                    System.out.println(temp.toString());
                    return;
                }

            }
        }
        System.out.println("NA");
    }
}
