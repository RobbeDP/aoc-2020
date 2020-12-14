public class Task1 {
    public int findEarliestBus(int timestamp, int[] busIDs) {
        int bestID = -1;
        int shortestWaitingTime = Integer.MAX_VALUE;
        for (int busID : busIDs) {
            if (busID != -1) {
                int missed = timestamp % busID;
                int waitingTime = (busID - missed) % busID;
                if (waitingTime < shortestWaitingTime) {
                    bestID = busID;
                    shortestWaitingTime = waitingTime;
                }
            }
        }

        return bestID * shortestWaitingTime;
    }
}
