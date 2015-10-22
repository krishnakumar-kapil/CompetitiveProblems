/**
 * Created by kapilkrishnakumar on 10/22/15.
 */
import java.util.*;
public class RPNCalc {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        Stack<Integer> rStack = new Stack<Integer>();

        for(int i = 0; i < length; i++){
            String s = sc.next();
//            System.out.println(s + " ");
            char c = s.charAt(0);;
//            System.out.println(rStack);
            if(s.length() == 1 && (c == '+' || c == '-' || c == '*')) {

                int val1 = rStack.pop();
                int val2 = rStack.pop();
                int result = 0;
                if (c == '+')
                    result = val1 + val2;
                else if (c == '-')
                    result = val2 - val1;
                else if (c == '*')
                    result = val1 * val2;
                else
                    throw new IllegalStateException();

                rStack.push(result);
            }
            else {
                int val = Integer.parseInt(s);
                rStack.push(val);
            }
        }

        if(rStack.isEmpty() || rStack.size()!= 1) throw new IllegalStateException();
        System.out.println(rStack.pop());

    }

}
