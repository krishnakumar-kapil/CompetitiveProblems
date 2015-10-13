import java.util.*;

/**
 * Created by kapilkrishnakumar on 9/9/15.
 */
public class CodeHWMaze {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        int width = sc.nextInt();
        int numWallsRequired = sc.nextInt();
        sc.nextLine();
        char[][] maze = new char[height][width];
        boolean[][] visited = new boolean[height][width];

        int numEmpty = 0;

        int[] currPos = {0,0};
        for(int i = 0; i < height; i++){
            String line = sc.nextLine();
            for(int j = 0; j < line.length(); j++){

                char c = line.charAt(j);
//                System.out.print(c);
                maze[i][j] = c;


                if(currPos[0] == 0 && currPos[1] == 0 && maze[i][j] == '.'){
                    currPos[0] = i;
                    currPos[1] = j;
                }

                if(c == '.') numEmpty++;

            }
//            System.out.println();
        }

//        printMaze(maze);

        Queue<int[]> q = new LinkedList<int[]>();
        q.add(currPos);
        int condition = numEmpty - numWallsRequired;
//        System.out.println(condition);
//        System.out.println(numEmpty);
        int seen = 0;
        int changed = 0;
        while(!q.isEmpty()){
            currPos = q.remove();
            if(!visited[currPos[0]][currPos[1]]) {
                seen++;
                visited[currPos[0]][currPos[1]] = true;
                if (seen > condition) {
                    //Only empty ones are added to the cell.
                    maze[currPos[0]][currPos[1]] = 'X';

                    changed++;
//                    System.out.println(changed);
//                    printMaze(maze);
                }

                int[] top = {currPos[0], currPos[1] - 1};
                int[] left = {currPos[0] - 1, currPos[1]};
                int[] bottom = {currPos[0], currPos[1] + 1};
                int[] right = {currPos[0] + 1, currPos[1]};
                addElem(q, top, maze, visited);
                addElem(q, bottom, maze, visited);
                addElem(q, left, maze, visited);
                addElem(q, right, maze, visited);
            }
        }

        printMaze(maze);
//
//        System.out.println(changed);

    }

    public static void addElem(Queue<int[]> q, int[] pos, char[][] maze, boolean[][] visited){
        if(0 <= pos[0] && pos[0] < maze.length && 0 <= pos[1] && pos[1] < maze[0].length) {
            if (maze[pos[0]][pos[1]] == '.' && !visited[pos[0]][pos[1]]) {
                q.add(pos);
            }
        }
    }

    public static void printMaze(char[][] maze){
        for(int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[0].length; j++){
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }
}
