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

    public static int dijkstra(int[][] adjMatrix, int start, int siloDist){
        final Map<Integer, Integer> dist = new HashMap<Integer,Integer>();
//        Map<Integer, Integer> prev = new HashMap<Integer, Integer>();
        int numSilo = 0;
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
//            System.out.println(q);
            int city = q.poll();
            int cityDist = !dist.containsKey(city) ? 0: dist.get(city);
            for(int e = 0; e < adjMatrix[0].length; e++){
                if(adjMatrix[city][e] != 0) {
//                    System.out.println("edge exists for city and "+e);
                    int length = adjMatrix[city][e];
                    int newLength = length + cityDist;
                    int destLength = dist.get(e) == null ? 0 : dist.get(e);
                    if (!dist.containsKey(e) || destLength > newLength ) {
                        dist.put(city, length);
                        q.add(e);
//                        prev.put(e, city);
                    }

                }
            }
        }


//        dist.put(start, 0);
        System.out.println(dist);

        for(int u = 0; u < adjMatrix.length; u++){
            int uDist = dist.containsKey(u) ?  dist.get(u) : 0;
//            System.out.println();
            System.out.println("u: "+u + "udist: "+uDist );
            if(uDist == siloDist) {
                System.out.println("AWESOME: "+u);
                numSilo++;
            }
            else{
                if(uDist < siloDist){
                    for(int v = 0; v < adjMatrix.length; v++){
                        if(adjMatrix[u][v] != 0) {
//                            System.out.println("u: " + u + " v: " + v);
                            int eWeight = adjMatrix[u][v];
                            int vDist = dist.containsKey(v) ? dist.get(v) : 0;
                            System.out.println("uDist: " + u + " vDist: " + v + " eWeight: " + eWeight + " dist: " + siloDist);
                            if (uDist + eWeight > siloDist) {
                                int distFU = siloDist - uDist;
                                int distFV = siloDist - vDist;
//                                System.out.println("distFU: "+distFU + " distFV: "+distFV);

                                if (distFU + distFV == eWeight) {
                                    if (u < v) {
//                                        System.out.println("uDist: " + u + " vDist: " + v + " eWeight: " + eWeight + " dist: " + siloDist);
                                        numSilo++;
                                    }
                                } else if (distFU + distFV < eWeight) {
                                    System.out.println("uDist: " + u + " vDist: " + v + " eWeight: " + eWeight + " dist: " + siloDist);
                                    numSilo++;
                                }
                            }
                        }
                    }
                }
            }
        }


//        for (int key : map.keySet()) {
//            Node node = map.get(key);
//            if (node.distance == L) {
//                count++;
//            } else {
//                if (node.distance < L) {
//                    for (int nborKey : node.nbors.keySet()) {
//                        Edge e = node.nbors.get(nborKey);
//                        if (node.distance + e.weight > L) {
//                            int srcDist = L - node.distance;
//                            int destDist = L - e.dest.distance;
//
//                            if (srcDist + destDist == e.weight) {
//                                if (e.src.id < e.dest.id) {
//                                    count++;
//                                }
//                            } else if (srcDist + destDist < e.weight) {
//                                count++;
//                            }
//                        }
//                    }
//                }
//            }
//        }
        return numSilo;
    }

    public static boolean addSilo(int distU, int distV, int siloDist, int w, int u, int v){
        System.out.println("u: "+u +" v: "+v);
        System.out.println("distU: "+distU + " distV: "+distV + " siloDist: "+siloDist+ " w: "+w);
        if(distU < siloDist && (siloDist - distU < w) && (w - (siloDist - distU) + distV > siloDist))
            return true;
        else if(distV < siloDist && (siloDist - distV < w) && (w - (siloDist - distV) + distU > siloDist))
            return true;
        else if(distU < siloDist && distV < siloDist && (distU + distV + w == 2*siloDist))
            return true;
//        else if(distU == siloDist || distV == siloDist)
//            return true;
        else
            return false;
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
