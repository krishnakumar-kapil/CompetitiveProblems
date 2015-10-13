/**
 * Created by kapilkrishnakumar on 10/13/15.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class UtopianTree {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for(int i = 0; i < num; i++){
            int n = sc.nextInt();
            int h = 1;
            for(int j = 0; j < n; j++){
                if(j % 2 == 0){
                    h *= 2;
                } else
                    h++;
            }
            System.out.println(h);
        }
    }
}