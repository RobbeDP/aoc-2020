import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task2 {
    public long findArrangements(List<Integer> joltages) {
        List<Integer> joltagesCopy = new ArrayList<>(joltages);
        Collections.sort(joltagesCopy);

        joltagesCopy.add(0,0);
        joltagesCopy.add(joltagesCopy.get(joltagesCopy.size() - 1) + 3);

        long[] arrangements = new long[joltagesCopy.size()];
        arrangements[0] = 1;
        for (int i = 1; i < joltagesCopy.size(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (joltagesCopy.get(i) - joltagesCopy.get(j) <= 3) {
                    arrangements[i] += arrangements[j];
                }
            }
        }

        return arrangements[joltagesCopy.size() - 1];
    }
}
