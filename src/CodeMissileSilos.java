import java.util.Scanner;
import java.util.*;

/**
 * Created by kapilkrishnakumar on 9/15/15.
 */
public class CodeMissileSilos {



        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt(); //num cities
            int m = sc.nextInt(); //num roads
            int capital = sc.nextInt() - 1; //capital - convert to array format

            int[][] adjMatrix = new int[n][n];

            for(int i = 0; i < m; i++){
                int c1 = sc.nextInt() - 1;
                int c2 = sc.nextInt() - 1;
                int length = sc.nextInt();

                adjMatrix[c1][c2] = length;
                adjMatrix[c2][c1] = length;
            }

//            print(adjMatrix);

            int distanceToSilo = sc.nextInt();

//            print(adjMatrix);
//            System.out.println(n + "\n" + m + "\n"+capital+ "\n"+distanceToSilo);

            System.out.println(dijkstra(adjMatrix, capital, distanceToSilo));
        }

//        public static int bfs(int[][] adjMatrix, int start, int siloDist){
//            Queue<Integer> q = new LinkedList<Integer>();
//            HashMap<Integer, Integer> dist = new HashMap<Integer, Integer>();
//            HashSet<Integer> visited = new HashSet<Integer>();
//
//            q.add(start);
//            visited.add(start);
//            dist.put(start, 0);
//            int numSilos = 0;
//            while(!q.isEmpty()){
//                int current = q.poll();
//                if(dist.containsKey(current) && dist.get(current) == siloDist)
//                    numSilos++;
//
////                if(dist.containsKey(current) && dist.get(current) > siloDist)
////                    break;
//                for(int m = 0; m < adjMatrix.length; m++){
//                    if(!visited.contains(m)) {
//                        int length = adjMatrix[current][m];
//                    }
//                }
//            }
//
//            return numSilos;
//        }

    public static int dijkstra(int[][] adjMatrix, int start, int siloDist){
        final Map<Integer, Integer> dist = new HashMap<Integer,Integer>();
        Map<Integer, Integer> prev = new HashMap<Integer, Integer>();
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(adjMatrix.length, new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2) {
                Integer dist1 = dist.get(o1);
                Integer dist2 = dist.get(o2);
                if(dist1 == null) dist1 = Integer.MAX_VALUE;
                if(dist2 == null) dist2 = Integer.MAX_VALUE;
                return dist1 - dist2;
            }
        });
//        System.out.println(dist);
        q.add(start);
        dist.put(start, 0);
        while(!q.isEmpty()){
            System.out.println(q);
            int city = q.poll();
            int cityDist = !dist.containsKey(city) ? 0: dist.get(city);
            for(int e = 0; e < adjMatrix[0].length; e++){
                if(adjMatrix[city][e] != 0) {
//                    System.out.println("edge exists for city and "+e);
                    int length = adjMatrix[city][e];
                    int newLength = length + cityDist;
                    if (!dist.containsKey(e) || dist.get(e) >= newLength ) {
                        dist.put(city, length);
                        q.add(e);
                        prev.put(e, city);
                    }
                }
            }
        }

        System.out.println(dist);

        int numSilo = 0;
        for(int city = 0; city < adjMatrix.length; city++){
            if(dist.containsKey(city) && dist.get(city) <= siloDist)
                numSilo++;
        }
        return numSilo;
    }

    public static void print(int[][] adjMatrix){
        for(int i = 0; i < adjMatrix.length; i++){
            for(int j = 0; j < adjMatrix[0].length; j++){
                System.out.print(adjMatrix[i][j] + ", ");
            }
            System.out.println();
        }
    }

//    public static class Node{
//
//    }



//        public static class Edge{
//            int dest;
//            int weight;
//            int start;
//        }
}
