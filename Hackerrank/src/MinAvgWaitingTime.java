/**
 * Created by kapilkrishnakumar on 10/14/15.
 */
import java.util.*;
public class MinAvgWaitingTime {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        PriorityQueue<Wait> pq = new PriorityQueue<Wait>(n, new Comparator<Wait>(){
            public int compare(Wait a, Wait b){
//                int t1 = a.timeArrived + a.cookTime;
//                int t2 = b.timeArrived + b.cookTime;
//                return t1 - t2;
//
//                int diffCook = a.cookTime - b.cookTime;
//                if(diffCook != 0) return diffCook;
//                return a.timeArrived - b.timeArrived;
//
//
//
                int diffTime = a.timeArrived - b.timeArrived;
                if(diffTime != 0)
                    return diffTime;
                return a.cookTime - b.cookTime;
            }
        });


        for(int i = 0; i < n; i++){
            int timeArrived = sc.nextInt();
            int cookTime = sc.nextInt();
            Wait w = new Wait(timeArrived, cookTime);
            pq.add(w);
        }
        System.out.println(pq);
        int time = 0;
        int totalWeightTime = 0;

        while(!pq.isEmpty()){
            Wait current = pq.poll();
            time = current.timeArrived;
            time += current.cookTime;
            totalWeightTime = time - current.timeArrived;

        }
        int average = totalWeightTime / n;
        System.out.println(average);
    }


    public static class Wait{
        int timeArrived;
        int cookTime;

        public Wait(int timeArrived, int cookTime) {
            this.timeArrived = timeArrived;
            this.cookTime = cookTime;
        }

        @Override
        public String toString() {
            return "Wait{" +
                    "timeArrived=" + timeArrived +
                    ", cookTime=" + cookTime +
                    '}';
        }
    }
}
