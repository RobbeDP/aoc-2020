import java.util.List;

public class Task1 {
    public Integer findNumber(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i) + numbers.get(j) == 2020) {
                    return numbers.get(i) * numbers.get(j);
                }
            }
        }

        return null;
    }
}
