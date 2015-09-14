import java.util.*;

/**
 * Created by kapilkrishnakumar on 9/11/15.
 */
public class CodeSerialTime {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();


        char[][][] plate = new char[k][n][m];
//        System.out.println("height: "+k + " x: "+n + " y: "+m);
        sc.nextLine();
        sc.nextLine();

        int numEmpty = 0;
        for(int z = 0; z < k; z++){

            for(int x = 0; x < n; x++){
                String line = sc.nextLine();
                for(int y = 0; y < m; y++){
//                    System.out.println("z: "+z + " x: "+x + " y: "+y);
                    plate[z][x][y] = line.charAt(y);
                    if(line.charAt(y) == '.') numEmpty++;
                }
            }
            //blank line
            sc.nextLine();
        }
        int tapX = sc.nextInt() - 1;
        int tapY = sc.nextInt() - 1;
//        printPlate(plate);
//        System.out.println("tap: "+tapX+", "+tapY);

        System.out.println(bfs(plate, tapX, tapY, numEmpty));
    }


    public static int bfs(char[][][] plate, int startX, int startY, int numEmpty){
        boolean[][][] visited = new boolean[plate.length][plate[0].length][plate[0][0].length];
        int timeCounter = 0;

        int[] currentPos = {0, startX, startY};
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(currentPos);
        visited[currentPos[0]][currentPos[1]][currentPos[2]] = true;

        while(!q.isEmpty()){
            int[] pos = q.poll();
            int z = pos[0];
            int x = pos[1];
            int y = pos[2];
//            System.out.println(Arrays.toString(pos));
            timeCounter++;
            numEmpty--;
            if(numEmpty == 0)
                return timeCounter;

            //add next to queue
            int[] dz6 = {-1, 0, 1, 0, 0, 0};
            int[] dx6 = {0, 1, 0, 0, 0, -1};
            int[] dy6 = {0, 0, 0, 1, -1, 0};

            for(int d = 0; d < dz6.length; d++){
                for(int a = 0; a < dx6.length; a++){
                    for(int b = 0; b < dy6.length; b++){
                        int xdx = x + dx6[a];
                        int ydy = y + dy6[b];
                        int zdz = z + dz6[d];
                        if(0 <= zdz && zdz < visited.length && 0 <= xdx && xdx < visited[0].length &&
                                0 <= ydy && ydy < visited[0][0].length){
                            if(plate[zdz][xdx][ydy] == '.'  && !visited[zdz][xdx][ydy]) {
                                int[] addPos = {zdz, xdx, ydy};
                                visited[zdz][xdx][ydy] = true;
                                q.add(addPos);
//                                System.out.println(Arrays.toString(addPos));
//                                System.out.println(visited[zdz][xdx][ydy]);
                            }
                        }
                    }
                }
            }

        }
        return timeCounter;
    }

//    public static int[] addNext(int[] current, boolean[][][] visited){
//        int[] dz6 = {-1, 0, 1, 0, 0, 0};
//        int[] dx6 = {0, 1, 0, 0, 0, -1};
//        int[] dy6 = {0, 0, 0, 1, -1, 0};
//
//        int z = current[0];
//        int x = current[1];
//        int y = current[2];
//
//        for(int d = 0; d < dz6.length; d++){
//            for(int a = 0; a < dx6.length; a++){
//                for(int b = 0; b < dy6.length; b++){
//                    int xdx = x + dx6[a];
//                    int ydy = y + dy6[b];
//                    int zdz = z + dz6[d];
//                    if(0 <= zdz && zdz <= visited.length && 0 <= xdx && xdx <= visited[0].length &&
//                            0 <= ydy && ydy <= visited[0][0].length && !visited[zdz][xdx][ydy]){
//                        return new int[]{zdz, xdx, ydy};
//                    }
//                }
//            }
//        }
//    }

    public static void printPlate(char[][][] plate){
        for(int z = 0; z < plate.length; z++){
            for(int x = 0; x < plate[0].length; x++){
                for(int y = 0; y < plate[0][0].length; y++){
                    System.out.print(plate[z][x][y]+ " ");
                }
                System.out.println();
            }
            //blank line
            System.out.println();
        }
    }
}

