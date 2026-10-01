import java.util.*;

public class RoundRobinScheduler {
    public static List<Integer> schedule(int[] burstTimes, int quantum) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] remaining = burstTimes.clone();
        List<Integer> order = new ArrayList<>();

        for (int i=0;i<remaining.length;i++) queue.add(i);

        while(!queue.isEmpty()) {
            int task=queue.poll();
            order.add(task+1);
            remaining[task] -= Math.min(quantum, remaining[task]);
            if(remaining[task]>0) queue.add(task);
        }
        return order;
    }
}
