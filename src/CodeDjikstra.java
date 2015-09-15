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
//        System.out.println(n + " "+m);

        Map<Node, List<Edge>> adjList = new HashMap<Node, List<Edge>>();

        //Setup method
        for(int i = 0; i < m; i++){
            int n1Val = sc.nextInt();
            int n2Val = sc.nextInt();
            int weight = sc.nextInt();
            Node n1 = new Node();
            Node n2 = new Node();
            n1.value = n1Val;
            n2.value = n2Val;

//            System.out.println(n1 + " " + n2 + " " + weight);

            Edge e1 = new Edge(weight, n2);
            Edge e2 = new Edge(weight, n1);
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
        }
        Node n2 = new Node();
        n2.value = n;
        Node n1 = new Node();
        n1.value = 1;
        System.out.print(dijkstra(adjList, n1, n2));
        sc.close();
    }

    public static String dijkstra(Map<Node, List<Edge>> adjList, Node start, Node end){
        final Map<Node, Integer> dist = new HashMap<Node, Integer>();
        final Map<Integer, Integer> prev = new HashMap<Integer, Integer>();
        PriorityQueue<Node> q = new PriorityQueue<Node>(adjList.size(), new Comparator<Node>(){
            public int compare(Node o1, Node o2) {
                Integer dist1 = dist.get(o1);
                Integer dist2 = dist.get(o2);
                if(dist1 == null) dist1 = Integer.MAX_VALUE;
                if(dist2 == null) dist2 = Integer.MAX_VALUE;
                return dist1 - dist2;
            }
        });
        q.add(start);
        dist.put(start, 0);
//        System.out.println("start" + start + " end "+end);

        while(!q.isEmpty()){
//            System.out.println(q);
            Node node = q.poll();

            if(node.equals(end)){
                int current = end.value;
                StringBuilder result = new StringBuilder();
                while(current != start.value){
                    result.insert(0, current+ " ");
                    current = prev.get(current);
                }
                result.insert(0,current + " ");
                return result.toString();

            }
            if(adjList.containsKey(node)) {
                for (Edge e : adjList.get(node)) {
//                    System.out.println(e);
                    int weight = dist.get(node) == null ? 0 : dist.get(node);
                    int newDist = e.weight + weight;
                    if (!dist.containsKey(e.dest) || dist.get(e.dest) > newDist) {
                        dist.put(e.dest, newDist);
                        q.add(e.dest);
                        prev.put(e.dest.value, node.value);
                    }
                }
            }
        }
//        System.out.println(dist);


        return "-1";

    }


    public static class Edge{
        int weight;
        Node dest;


        public Edge(int weight, Node dest) {
            this.weight = weight;
            this.dest = dest;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "weight=" + weight +
                    ", dest=" + dest +
                    '}';
        }
    }

    public static class Node{
        int value;
        int prevNode;

        public Node(int value, int prevNode) {
            this.value = value;
            this.prevNode = prevNode;
        }

        public Node() {
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", prevNode=" + prevNode +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return value == node.value;

        }

        @Override
        public int hashCode() {
            return value;
        }
    }
}
