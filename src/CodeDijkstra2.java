import java.util.*;

/**
 * Created by kapilkrishnakumar on 9/15/15.
 */
public class CodeDijkstra2 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Edge>[] edges = new ArrayList[n + 1];
        for(int i = 0;i <= n; i++)
            edges[i]=new ArrayList();


//        int[][] adjMatrix = new int[n][n];
        for(int i = 0; i < m ; i++){
            int n1Val = sc.nextInt() - 1;
            int n2Val = sc.nextInt() - 1;
            int weight = sc.nextInt();

            edges[n1Val].add(new Edge(n2Val, weight));
            edges[n2Val].add(new Edge(n1Val, weight));
        }
//        for(int k = 0; k < edges.length; k++)
//            System.out.println(edges[k]);
        System.out.println(dijkstra(edges, 0, n, n));
    }

    public static String dijkstra(ArrayList<Edge>[] edges, int start, int end, int totalV){
        HashSet<Integer> visited = new HashSet<Integer>();
//        HashMap<Node, Node> prev= new HashMap<Node, Node>();
        int[] prev = new int[totalV];
        Arrays.fill(prev, -1);
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.offer(new Node(start, -1, 0));
        while(!pq.isEmpty()){
//            System.out.println(pq);
            Node curr = pq.poll();
            if(visited.contains(curr.value)) continue;

            visited.add(curr.value);
//            int prevN = prev[curr.value];
            prev[curr.value] = curr.prev;
            for(Edge v:edges[curr.value]){
                if(visited.contains(v.dest))continue;
//                System.out.println(v.dest+" "+curr.value+" "+(curr.cost + v.weight));
                pq.add(new Node(v.dest, curr.value ,curr.cost + v.weight));
            }
        }

        StringBuilder sb=new StringBuilder();
        int c = end - 1;
        Stack<Integer> st = new Stack<Integer>();
        while(prev[c] != -1){
            st.push(c + 1);
            c=prev[c];
        }
        st.push(1);
        while(!st.isEmpty()) sb.append(st.pop()+" ");
        if(prev[end - 1] == -1)System.out.print("-1");
        else System.out.print(sb);

        return "";
    }


    public static class Edge{
        int dest;
        int weight;

        public Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "dest=" + dest +
                    ", weight=" + weight +
                    '}';
        }
    }

    public static class Node  implements Comparable<Node>{
        int value;
        int prev;
        int cost;

        public Node(int value, int prev, int cost){
            this.value = value;
            this.prev = prev;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return this.cost - o.cost;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", prev=" + prev +
                    ", cost=" + cost +
                    '}';
        }
    }

}
