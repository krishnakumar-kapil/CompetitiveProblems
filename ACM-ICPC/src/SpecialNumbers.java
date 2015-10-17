import java.util.*;

/**
 * Created by kapilkrishnakumar on 10/16/15.
 */
public class SpecialNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] primes=new boolean[10000];

        fillSieve(primes);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
            int n = sc.nextInt();
            int special = 0;


            //1 never happening
            //2 never happening
            //3 never

            for(int i = 2; i <= n; i++){
                int factors = 0;
                int primeNumbers = 0;

                if(!primes[i]) {
                    for (int j = 2; j < i; j++) {
//                        System.out.println(j + " " + primes[j]);
                        if (i % j == 0) {
                            if (primes[j])
                                primeNumbers++;
                            else
                                factors++;
                        }

                    }
                    if (primeNumbers == 2 && factors == 0) {
                        special++;
                    }
//                    System.out.println("Primes: "+primeNumbers);
//                    System.out.println("Others: "+factors);
//                    System.out.println();
                }
            }
            System.out.println(special);
        }
    }

    public static void fillSieve(boolean[] primes) {
        Arrays.fill(primes,true);        // assume all integers are prime.
        primes[0]=primes[1]=false;       // we know 0 and 1 are not prime.

        for (int i=2;i<primes.length;i++) {
            //if the number is prime,
            //then go through all its multiples and make their values false.
            if(primes[i]) {
                for (int j=2;i*j<primes.length;j++) {
                    primes[i*j]=false;
                }
            }
        }
    }
}
