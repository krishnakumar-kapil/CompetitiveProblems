import java.util.*;

/**
 * Created by kapilkrishnakumar on 10/2/15.
 */
public class ICPC2 {

    public static void main(String[] main){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        for(int z = 1; z <= n; z++){

            int k = sc.nextInt();
            int minSum = 0;
            int maxSum = 0;
            for(int i = 0; i < k; i++){
                String s = sc.next();
                String maxnum = "";
                String minnum = "";
//                boolean firstHash = false;
                boolean neg = false;
                for(int c = 0; c < s.length(); c++){
                    char a = s.charAt(c);
                    if(a == '#'){
                        int max = 9;
                        int min = 0;
                        if(neg){
                            max = 0;
                            min = 9;
                            if(c == 1) {
                                min = 9;
                                max = 1;
                            }
                        }
                        if(c == 0){
                            min = 1;
//                            firstHash = true;
                        }
                        maxnum += max;
                        minnum += min;
                    } else {
                        if(a == '-')
                            neg = true;
                        maxnum += a;
                        minnum += a;
                    }
//                    System.out.println("maxnum "+maxnum+ " minnum: "+minnum);
                }
                maxSum += Integer.parseInt(maxnum);
                minSum += Integer.parseInt(minnum);


            }
            System.out.println("Case "+z+": "+minSum + " "+maxSum);
        }
    }
}
