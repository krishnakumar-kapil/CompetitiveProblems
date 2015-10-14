/**
 * Created by kapilkrishnakumar on 10/14/15.
 */
import java.util.*;
public class LeastRoundWay {

    static int n;
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int size = sc.nextInt();
//        int[][] matrix = new int[size][size];
//
//        for(int r = 0; r < matrix.length; r++){
//            for(int c = 0; c < matrix.length; c++){
//                int val = sc.nextInt();
//                matrix[r][c] = val;
//            }
//        }
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int[][] fact2=new int[n][n]; //Array for numbers with factor of 2
        int[][] fact5=new int[n][n]; //Array for numbers with factor of 5
        boolean zero = false;
        int zX=0,zY=0;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                int num = in.nextInt();
                if(num == 0)
                {
                    zero = true;
                    zX = i;
                    zY = j;
                }
                else
                {
                    if(num % 5 == 0)
                    {
                        while(num % 5 == 0)
                        {
                            num /= 5;
                            fact5[i][j] = fact5[i][j] + 1;
                        }
                    }
                    if(num % 2 == 0)
                    {
                        while(num % 2 == 0)
                        {
                            num /= 2;
                            fact2[i][j] = fact2[i][j] + 1;
                        }
                    }
                }
            }
        }

        iterate(fact2);
        iterate(fact5);
        int z = (zero) ? 1 : Integer.MAX_VALUE;
        int best = Math.min(z, Math.min(fact2[n-1][n-1],fact5[n-1][n-1]));
        System.out.println(best);
        if(best==1&&zero)
        {
            for(int i=0;i<zX;i++)
                System.out.print("D");
            for(int j=0;j<zY;j++)
                System.out.print("R");
            for(int i=0;i<n-zX-1;i++)
                System.out.print("D");
            for(int j=0;j<n-zY-1;j++)
                System.out.print("R");
            System.out.println();
        }else if(best==fact5[n-1][n-1]){
            System.out.println(printPath(n-1,n-1,fact5));
        }else{
            System.out.println(printPath(n-1,n-1,fact2));
        }
    }
    static StringBuffer printPath(int i,int j,int[][] dp)
    {
        StringBuffer ret=new StringBuffer("");
        if(i==0){
            for(int m=0;m<j;m++)
                ret.append("R");
        }else if(j==0){
            for(int m=0;m<i;m++)
                ret.append("D");
        }else{
            if(dp[i][j-1]<=dp[i-1][j]){
                ret.append(printPath(i,j-1,dp));
                ret.append("R");
            }else{
                ret.append(printPath(i-1,j,dp));
                ret.append("D");
            }
        }
        return ret;
    }
    static void iterate(int[][] fact){

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(!(i==0 && j == 0))
                {
                    if(i == 0)
                        fact[i][j] += fact[i][j-1];
                    else if(j == 0)
                        fact[i][j] += fact[i-1][j];
                    else
                        fact[i][j] += Math.min(fact[i][j-1], fact[i-1][j]);
                }
            }
        }
    }

    }

