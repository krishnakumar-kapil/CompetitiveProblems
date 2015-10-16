import java.util.*;

/**
 * Created by kapilkrishnakumar on 10/16/15.
 */
public class RobotGrid {

    public ArrayList<Point> getPath(int[][] a){
        int startX = 0;
        int startY = 0;

        ArrayList<Point> path = new ArrayList<Point>();
        HashMap<Point, Boolean > visited = new HashMap<Point, Boolean>();
        if(getPath(a, a.length - 1, a[0].length - 1, path, visited))
            return path;
        return null;
    }

    public boolean getPath(int[][] a, int row, int col, ArrayList<Point> path, HashMap<Point, Boolean> visited){
        if(!validPosition(a, row, col)) return false;

        Point p = new Point(row, col);
        if(visited.containsKey(p)) return true;

        boolean isAtOrigin = row == 0 && col == 0;
        if(isAtOrigin || getPath(a , row - 1, col , path, visited) || getPath(a, row, col - 1 , path, visited)) {
            path.add(p);
            return true;
        }
        return false;
    }

    public boolean validPosition(int[][] grid, int x, int y){
        if(0 <= x && x < grid.length && 0 <= y && y < grid[0].length && grid[x][y] != 0) return true;
        return false;
    }

    public class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
