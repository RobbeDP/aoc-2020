import java.util.List;

public class Task2 {
    public long countTrees(List<String> forest, int[][] slopes) {
        Task1 task1 = new Task1();

        long product = 1;
        for (int[] currentSlope : slopes) {
            product *= task1.countTrees(forest, currentSlope[0], currentSlope[1]);
        }

        return product;
    }
}
