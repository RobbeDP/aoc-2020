import java.util.List;

public class Task2 {
    public long findWeakness(List<Long> numbers, int preamble) {
        long invalid = new Task1().findWeakness(numbers, preamble);

        for (int i = 0; i < numbers.size() - 1; i++) {
            long currentSum = numbers.get(i);
            for (int j = i + 1; j < numbers.size(); j++) {
                currentSum += numbers.get(j);
                if (currentSum == invalid) {
                    return boundarySum(numbers.subList(i, j + 1));
                }
            }
        }

        return -1;
    }

    private long boundarySum(List<Long> contagiousSet) {
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for (long number: contagiousSet) {
            if (number > max) max = number;
            if (number < min) min = number;
        }

        return min + max;
    }
}
