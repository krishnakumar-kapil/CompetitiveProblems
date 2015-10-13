import java.util.*;
import java.io.*;
import java.util.Scanner;

public class p1 {

    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        while(num >= 0){
            int v = s.nextInt();
            TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
            while(v / 10 != 0){
                if(tm.containsKey(v%10))
                    tm.put(v%10, tm.get(v%10) + 1);
                else
                    tm.put(v%10, tm.get(1));
                v /= 10;
            }
            int res = 0;
            while(!tm.isEmpty()){
                int f = tm.get(tm.lastKey());
                for(; f >= 0; f--)
                    res = 10*res + tm.lastKey();
                tm.remove(tm.lastKey());
            }
            System.out.println(res);
            num--;
        }


    }

}
