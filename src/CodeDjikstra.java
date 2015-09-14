import java.util.*;
import java.util.Comparator;

/**
 * Created by kapilkrishnakumar on 9/11/15.
 */
public class CodeDjikstra {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(n + " "+m);

        Map<Integer, List<Edge>> adjList = new HashMap<Integer, List<Edge>>();
        List<int[]> resPos = new LinkedList<int[]>();

        //Setup method
        for(int i = 0; i < m; i++){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int weight = sc.nextInt();
//            System.out.println(n1 + " " + n2 + " " + weight);
            int[] toFind = {n2, n1};

            Edge e1 = new Edge();
            Edge e2 = new Edge();
            e1.weight = weight;
            e1.dest = n2;
            if(!adjList.containsKey(n1)){
                List<Edge> edges = new LinkedList<Edge>();
                edges.add(e1);
//                System.out.println(edges);
                adjList.put(n1, edges);
            } else {
                adjList.get(n1).add(e1);
            }

            e2.weight = weight;
            e2.dest = n1;
            if(!adjList.containsKey(n2)){
                List<Edge> edges = new LinkedList<Edge>();
                edges.add(e2);
//                System.out.println(edges);
                adjList.put(n2, edges);
            } else {
                adjList.get(n2).add(e2);
            }


            resPos.add(toFind);
        }

        for(int[] pos: resPos){
            System.out.print(dijkstra(adjList, pos[0], pos[1]) + " ");
        }

    }

    public static int dijkstra(Map<Integer, List<Edge>> adjList, int start, int end){
        Map<Integer, Integer> dist = new HashMap<Integer, Integer>();
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(10, new Compare());
        q.add(start);
        dist.put(start, 0);

        while(!q.isEmpty()){
            System.out.println(q);
            int node = q.poll();
            int weight = dist.get(node) == null ? 0 : dist.get(node);

            if(node == end){
                System.out.println("reached end");
                System.out.println(dist.get(node));
                return dist.get(node);
            }
            System.out.println(adjList.get(node));
            if(adjList.containsKey(node)) {
                for (Edge e : adjList.get(node)) {
                    System.out.println(e);
                    int newDist = e.weight + weight;
                    if (!dist.containsKey(e.dest) || newDist < weight) {
                        dist.put(node, newDist);
                    }
                    q.add(e.dest);
                }
            }
        }
        System.out.println(dist);
        if(!dist.containsKey(end)) return -1;
        return dist.get(end);
    }


    public static class Edge{
        int weight;
        int dest;

        @Override
        public String toString() {
            return "Edge{" +
                    "weight=" + weight +
                    ", dest=" + dest +
                    '}';
        }
    }

    public static class Compare implements Comparator<Integer>{
        public int compare(Integer o1, Integer o2) {
            if()
            return o2 - o1;
        }
    }
}
