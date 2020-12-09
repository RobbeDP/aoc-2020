import java.util.List;

public class Task1 {
    public long findWeakness(List<Long> numbers, int preamble) {
        for (int i = preamble; i < numbers.size(); i++) {
            if (! checkNumber(numbers.subList(i - preamble, i), numbers.get(i))) {
                return numbers.get(i);
            }
        }

        return -1;
    }

    public boolean checkNumber(List<Long> numbers, long number) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i) + numbers.get(j) == number) {
                    return true;
                }
            }
        }
        return false;
    }
}
