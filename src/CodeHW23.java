/**
 * Created by kapilkrishnakumar on 9/9/15.
 */

import java.util.*;
public class CodeHW23 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();

//        System.out.println("h:"+h+" w:"+w );
        int numWalls = sc.nextInt();
        char[][] maze = new char[w][h];
        System.out.println("width: "+maze.length +"height: "+maze[0].length);
        boolean[][] visited = new boolean[w][w];

        int[] pos = {0,0};
        int numEmpty = 0;
        int j = 0;
//        System.out.println("j"+j);
        sc.nextLine();
        for(; j < h; j++){
            String line = sc.nextLine();
//            System.out.println(line);
            for(int i = 0; i < line.length(); i++){
//                System.out.println("J:"+j);
//                System.out.println("i: "+i+" j: "+j);

                maze[i][j] = line.charAt(i);
//                System.out.println("val:"+line.charAt());
                if(pos[0] == 0 && pos[1] == 0 && maze[i][j] == '.'){
                    pos[0] = i;
                    pos[1] = j;
                }
                if(maze[i][j] == '.')
                    numEmpty++;
            }
            System.out.println("j"+j);
//            j++;
        }
        System.out.println("starting");
        j = 0;
        for(int i = 0; i < maze.length; i++){
            for(; j < maze[0].length; j++){
                System.out.println("i: "+i+" j: "+j);
                System.out.print(maze[i][j]);
            }
            System.out.print("\n");
        }

        Queue<int[]> q = new LinkedList<int[] >();
        q.add(pos);
        visited[0][0] = true;
        int seen = 1;
        int requiredSeen = h*w - numWalls;
        boolean complete = false;
        System.out.println("starting");
        while(!q.isEmpty() && !complete){
            int[] currPos = q.remove();
            System.out.println(Arrays.toString(currPos));
            seen++;
            if(seen >= requiredSeen){
                maze[currPos[0]][currPos[1]] = 'X';
            }
            int x = currPos[0];
            int y = currPos[1];
            for (int dx = (x > 0 ? -1 : 0); dx <= (x < w ? 1 : 0); dx++){
                for (int dy = (y > 0 ? -1 : 0); dy <= (y < h ? 1 : 0); dy++){
//                    System.out.println("x:" + (x + dx) + " y:" + (y + dx));
                    if (dx != 0 || dy != 0){
                        if(x+dx < w && y+dy < h) {
                            if (maze[x + dx][y + dy] == '.' && !visited[x + dx][y + dy]) {
                                int[] newPos = {x + dx, y + dy};
                                q.add(newPos);
                            }
                        }
                    }
                }
            }
        }
        j = 0;
        for(int i = 0; i < w; i++){
            for(; j < h; j++){
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }

    }


}
