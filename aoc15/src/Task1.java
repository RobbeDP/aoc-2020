import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task1 {
    public long findNumber(List<Integer> numbers, int index) {
        Map<Integer, Integer> previouslySeen = new HashMap<>();

        for (int i = 0; i < numbers.size(); i++) {
            previouslySeen.put(numbers.get(i), i);
        }

        int previousNumber = numbers.get(numbers.size() - 1);
        for (int i = numbers.size(); i < index; i++) {
            int previous = previouslySeen.getOrDefault(previousNumber, -1);
            int age = 0;
            if (previous != -1) {
                age = i - previous - 1;
            }

            previouslySeen.put(previousNumber, i - 1);
            previousNumber = age;

        }

        return previousNumber;
    }
}
