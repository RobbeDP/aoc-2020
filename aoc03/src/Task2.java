import java.util.List;

public class Task2 {
    public long countTrees(List<String> forest) {
        long product = 1;
        int columns = forest.get(0).length();
        int[][] slopes = {{1, 1}, {3, 1}, {5, 1}, {7, 1}, {1, 2}};

        for (int[] currentSlope : slopes) {
            int x = 0;
            int y = 0;

            int count = 0;
            while (y < forest.size()) {
                if (forest.get(y).charAt(x) == '#') {
                    count++;
                }
                x = (x + currentSlope[0]) % columns;
                y += currentSlope[1];
            }
            product *= count;
        }

        return product;
    }
}
