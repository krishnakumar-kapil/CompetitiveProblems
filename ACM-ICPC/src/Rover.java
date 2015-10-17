import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by kapilkrishnakumar on 10/16/15.
 */
public class Rover {

    final static int[] dY = {0, 1, 0 , -1};
    final static int[] dX = {-1, 0, 1, 0};


    public static void main(String[] args)throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

//        Scanner sc = new Scanner(System.in);
        String[] tmp = in.readLine().split(" ");

        int test = Integer.parseInt(tmp[0]);
//        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
            tmp = in.readLine().split(" ");
            int n = Integer.parseInt(tmp[0]);
            int m = Integer.parseInt(tmp[1]);
            int robots = Integer.parseInt(tmp[2]);
            int q = Integer.parseInt(tmp[3]);

            int[][] grid = new int[n][m];
//            HashSet<RoverBot> bots = new HashSet<RoverBot>();
            RoverBot[] bots = new RoverBot[robots];
//            System.out.println(n+" "+m+" "+robots+" "+q);
            for(int i = 0; i < robots; i++){
                String[] line =in.readLine().split(" ");

                int r = Integer.parseInt(line[0]);
                int c = Integer.parseInt(line[1]);
                String dirS= line[2];
                int dir = 0;
                if(dirS.equals("N"))
                    dir = 0;
                else if(dirS.equals("E"))
                    dir = 1;
                else if(dirS.equals("S"))
                    dir = 2;
                else if(dirS.equals("W"))
                    dir = 3;
                RoverBot rb = new RoverBot(r, c , dir);
//                bots.add(rb);
                bots[i] = rb;
            }


            for(int row = 0; row < n; row++){
                String s = in.readLine();
                for(int c = 0 ; c < s.length(); c++){
                    char ch = s.charAt(c);
                    if(ch == '#') grid[row][c] = -1;
                    else {
                        int val = ch - '0';
                        grid[row][c] = val;
                    }
                }
            }

//            System.out.println(bots);

            //END OF SETUP

            int chemCollected = 0;

            for(RoverBot rb: bots){
                int time = 0;
                while(time < q){
//                    chemCollected += grid[rb.r][rb.c];
                    int newX = rb.r;
                    int newY = rb.c;
                    while(validPosition(grid, newX, newY) && time < q){
                        System.out.println(rb);
                        time++;
                        chemCollected += grid[newX][newY];
                        newX += dX[rb.dir];
                        newY += dY[rb.dir];
                        if(validPosition(grid, newX, newY)) {
                            rb.r = newX;
                            rb.c = newY;
                        } else
                            break;
                    }
//
                    rb.dir = (rb.dir + 1)  % 4;
                    time++;
                    chemCollected += grid[rb.r][rb.c];

//                    chemCollected += grid[rb.r][rb.c];
//                    time++;
                }
            }
//            for(int time = 0; time < q; time++){
//                //cycle through the rovers
//                //see whether they can move to next spot
//                //or rotate
//                for(RoverBot rb: bots){
//                    chemCollected += grid[rb.r][rb.c];
//
//
//                    int newX = rb.r + dX[rb.dir];
//                    int newY = rb.c + dY[rb.dir];
////
////                    System.out.println(rb);
////                    System.out.println("newX: "+newX);
////                    System.out.println("newY: "+newY);
//
//                    if(validPosition(grid, newX, newY)){
//                        rb.r= newX;
//                        rb.c = newY;
//                    }else {
//                        rb.dir = (rb.dir + 1)  % 4;
//                    }
//
//                }
////                System.out.println(bots);
//
//            }
            System.out.println(chemCollected);
        }
    }

    public static boolean validPosition(int[][] grid, int x, int y){
        if(0 <= x && x < grid.length && 0 <= y && y < grid[0].length && grid[x][y] != -1) return true;
        return false;
    }

    public static class RoverBot{
        int r;
        int c;
        int dir;

        public RoverBot(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }

        @Override
        public String toString() {
            return "RoverBot{" +
                    "x=" + r +
                    ", y=" + c +
                    ", dir=" + dir +
                    '}';
        }
    }


}
