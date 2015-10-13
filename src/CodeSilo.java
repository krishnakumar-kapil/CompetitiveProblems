import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CodeSilo {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = in.readLine().split(" ");

        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        int cap = Integer.parseInt(tmp[2]);
        Map<Integer, Node> map = new HashMap<Integer, Node>();

        for (int i = 0; i < m; i++) {
            String[] str = in.readLine().split(" ");
            int n1 = Integer.parseInt(str[0]);
            int n2 = Integer.parseInt(str[1]);
            int weight = Integer.parseInt(str[2]);

            Node first = map.containsKey(n1) ? map.get(n1) : new Node(n1);
            Node dest = map.containsKey(n2) ? map.get(n2) : new Node(n2);
            first.distance = Integer.MAX_VALUE;
            dest.distance = Integer.MAX_VALUE;

            Edge e = new Edge(first, dest, weight);
            if (first.nbors.containsKey(n2)) {
                if (weight < first.nbors.get(n2).weight) {
                    first.nbors.put(n2, e);
                }
            } else {
                first.nbors.put(n2, e);
            }


            e = new Edge(dest, first, weight);
            if (dest.nbors.containsKey(n1)) {
                if (weight < dest.nbors.get(n1).weight) {
                    dest.nbors.put(n1, e);
                }
            } else {
                dest.nbors.put(n1, e);
            }


            map.put(n1, first);
            map.put(n2, dest);
        }

        int dist =  Integer.parseInt(in.readLine());

        int start = cap;

        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        if (map.get(start) == null) {
            System.out.println(-1);
        } else {
            pq.add(map.get(start));
            map.get(start).distance = 0;
            int numSilo = 0;
            while (!pq.isEmpty()) {
                Node node = pq.poll();
                if (node.distance > dist) {
                    continue;
                }
                if (!node.visited) {
//                    System.out.println("id " + next.id);
                    node.visited = true;
                    for (int nborId : node.nbors.keySet()) {
                        Edge e = node.nbors.get(nborId);

                        if (node.distance + e.weight < e.dest.distance) {
                            e.dest.before = node;
                            e.dest.distance = node.distance + e.weight;
                        }
//                        if (!e.dest.visited) {
//                        }
                        pq.add(e.dest);
                    }
                }
            }
            for (int key : map.keySet()) {
                Node node = map.get(key);
//                System.out.println(key + " : "+node);
                if (node.distance == dist) {
                    numSilo++;
                } else {
                    if (node.distance < dist) {
                        for (int nborK : node.nbors.keySet()) {
                            Edge e = node.nbors.get(nborK);

//                            System.out.println(e + " : "+e.dest + " "+e.dest.distance);
                            if (node.distance + e.weight > dist) {
                                int srcDist = dist - node.distance;
                                int destDist = dist - e.dest.distance;
//                                System.out.println("distFU: "+srcDist + " distFV: "+destDist);
                                if (srcDist + destDist == e.weight) {
                                    if (e.src.id < e.dest.id) {
                                        numSilo++;
                                    }
                                } else if (srcDist + destDist < e.weight) {
                                    numSilo++;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(numSilo);
        }
    }

    private static void printPath(Node node) {
        while(node != null) {
            System.out.print(node.id + " ");
            node = node.before;
        }
        System.out.println();
    }

    static class Node implements Comparable<Node> {
        int id;
        Map<Integer, Edge> nbors;
        boolean visited;
        int distance;
        Node before;

        public Node(int id) {
            this.id = id;
            visited = false;
            nbors = new HashMap<Integer, Edge>();
            distance = 0;
        }

        public int compareTo(Node other) {
            return distance - other.distance;
        }

        @Override
        public int hashCode() {
            return id;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Node) {
                return ((Node) obj).hashCode() == hashCode();
            }
            return false;
        }

        public String toString() {
            return id + " " + distance;
        }
    }

    static class Edge {
        Node src;
        Node dest;
        int weight;

        public Edge(Node src, Node dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;

        }
    }

}