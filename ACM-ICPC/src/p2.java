
import java.util.*;
import java.io.File;
import java.io.*;
import java.util.Scanner;

public class p2 {

    public static void main(String[] arg) throws IOException{
//        Scanner sc = new Scanner(System.in);
//
//        while(sc.hasNext()){
//            int ants = sc.nextInt();
//            ArrayList<Ant> al = new ArrayList<Ant>();
//            for(int i = 0; i < ants;i++){
//                double dist = sc.nextDouble();
//                String val = sc.next();
//                al.add(new Ant(dist, val.equals("right") ? true : false, 0));
//            }
//
//            while(true){
//                for(Ant a: al){
//                    a.time++;
//                    a.pos += a.dir ? 1: -1;
//                    if(a.pos == 0 || a.pos == 100)
//                        break;
//                }
//            }
//
//            for(Ant a: al)
//                System.out.println(a.time);
//        }
//
//

        }

    private static class Ant{
        double pos;
        boolean dir;
        double time;

        public Ant(double pos, boolean dir, double time){
            this.pos = pos;
            this.dir = dir;
            this.time = time;
        }
    }
    }