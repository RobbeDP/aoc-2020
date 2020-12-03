import java.util.List;

public class Task1 {
    public int countTrees(List<String> forest, int xSlope, int ySlope) {
        int columns = forest.get(0).length();

        int x = 0;
        int count = 0;
        for (int y = 0; y < forest.size(); y += ySlope) {
            if (forest.get(y).charAt(x) == '#') {
                count++;
            }
            x = (x + xSlope) % columns;
        }

        return count;
    }
}
