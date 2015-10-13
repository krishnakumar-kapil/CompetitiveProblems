/**
 * Created by kapilkrishnakumar on 10/2/15.
 */
import java.util.*;
public class ICPC1 {

    public static void main(String[] main){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for(int i = 1; i <= num ; i++){
            String card = sc.next();
            int exp = sc.nextInt();
            String result = "BOGUS";
            if(card.length() == 8){
                int cardNum = Integer.parseInt(card);
                int first = card.charAt(0) - '0';
//                int first =  cardNum / 10000000;
                System.out.println(first);
                if(first % 2 == 1 ){
                    int month = exp / 100;
                    System.out.println(month);
                    if(1 <= month && month <= 12){
                        if(cardNum % exp == 0){
                            System.out.println(exp);
                            result = "VALID";
                        }
                    }
                }

            }
            System.out.println("Case "+i+": "+result);
        }

//        for(int i = 1; i <= num ; i++){
//            String card = sc.next();
//            int exp = sc.nextInt();
//            int cardNum = Integer.parseInt(card);
//            String result = "BOGUS";
//
//            if(card.length() == 8){
////                System.out.println(card.length());
//                int first = cardNum / 10000000;
////                System.out.println("firstdig: "+first);
//                if(first % 2 == 1){
//                    int expMonth = exp / 100;
////                    System.out.println("month: "+expMonth);
//                    if(expMonth >= 1 && expMonth <= 12){
////                        System.out.println("div: "+(cardNum %exp));
//                        if(cardNum % exp == 0)
//                            result = "VALID";
//                    }
//                }
//            }
//
//
//            System.out.println("Case "+i+": "+result);
//        }


    }
}
