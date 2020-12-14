import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public long findEarliestTimestamp(int[] busIDs) {
        List<Long> n = new ArrayList<>();
        List<Long> a = new ArrayList<>();

        for (int i = 0; i < busIDs.length; i++) {
            if (busIDs[i] != -1) {
                n.add((long) busIDs[i]);
                // Modulo instead of remainder
                a.add((long) Math.floorMod(-i, busIDs[i]));
            }
        }

        return CRT(n, a);
    }

    /*
        Goal: find t such that t + i = 0 mod (busID), with i index of busID
        or such that t = -i mod busID.
     */
    private long CRT(List<Long> n, List<Long> a) {
        long N = n.stream().reduce((x, y) -> x * y).orElseThrow();
        long sum = 0;
        for (var i = 0; i < n.size(); i++) {
            long p = N / n.get(i);
            sum += a.get(i) * BigInteger.valueOf(p).modInverse(BigInteger.valueOf(n.get(i))).longValue() * p;
        }

        return sum % N;
    }
}
