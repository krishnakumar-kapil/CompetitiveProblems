import java.util.*;

/**
 * Created by kapilkrishnakumar on 9/11/15.
 */
public class CodeDjikstra {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

//        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        int[][] graph = new int[n][m];

        for(int i = 0; i < m; i++){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int weight = sc.nextInt();
            graph[n1][n2] = weight;
        }

        Queue<Integer> q = new LinkedList<Integer>();
        Set<Integer> visited = new HashSet<Integer>();

        while(!q.isEmpty()){
            int node = q.remove();
            if(!visited.contains(node)){
                visited.add(node);
            }
        }

    }

    public class Node{
        int value;
        int path;
    }

}
