import java.util.Scanner;

/**
 * Created by kapilkrishnakumar on 10/16/15.
 */
import java.util.*;
public class Maglev {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
            int n  = sc.nextInt();
            int m  = sc.nextInt();
            int x  = sc.nextInt();
//            HashMap<Integer, ArrayList<Edge>> edges = new HashMap<Integer, ArrayList<Edge>>();

            int[][] graph = new int[n][n];

            for(int i = 0; i < graph.length; i++){
                Arrays.fill(graph[i], -1);
            }
            for(int j = 0; j < m; j++){
                int s1 = sc.nextInt();
                int s2 = sc.nextInt();
                int time = sc.nextInt();

                graph[s1][s2] = time;
//                Edge e = new Edge(s2, time);
//                Edge f = new Edge(s1, time);
//                if(edges.containsKey(s1)){
//                    edges.get(s1).add(e);
//                } else{
//                    ArrayList<Edge> sEdge = new ArrayList<Edge>();
//                    sEdge.add(e);
//                    edges.put(s1, sEdge);
//                }
//
//                if(edges.containsKey(s2)){
//                    edges.get(s2).add(f);
//                } else{
//                    ArrayList<Edge> sEdge = new ArrayList<Edge>();
//                    sEdge.add(f);
//                    edges.put(s2, sEdge);
//                }
            }

//            System.out.println(edges);


            int price = 0;
            for(int r = 0; r < n; r++){
                for(int c = 0; c < n; c++){
                    if(graph[r][c] != -1){
                        int val = graph[r][c];
                        if(val < x)
                            continue;
                        else {



                        }

                    }
                }
            }

        }
    }

    public static class Edge{
        int time;
        int dest;

        public Edge(int time, int dest) {

            this.time = time;
            this.dest = dest;
        }


        public Edge()
        {
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "dest=" + dest +
                    ", time=" + time +
                    '}';
        }
    }
}
