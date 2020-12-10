import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task1 {
    public int findDifferences(List<Integer> joltages) {
        List<Integer> joltagesCopy = new ArrayList<>(joltages);
        Collections.sort(joltagesCopy);

        int countOne = 0;
        int countThree = 0;

        joltagesCopy.add(0,0);
        joltagesCopy.add(joltagesCopy.get(joltagesCopy.size() - 1) + 3);
        for (int i = 1; i < joltagesCopy.size(); i ++) {
            int difference = joltagesCopy.get(i) - joltagesCopy.get(i - 1);
            if (difference > 3) break;
            if (difference == 1) countOne++;
            if (difference == 3) countThree++;
        }

        return countOne * countThree;
    }
}
