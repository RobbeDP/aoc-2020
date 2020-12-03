import java.util.List;

public class Task1 {
    public int countTrees(List<String> forest) {
        int columns = forest.get(0).length();
        int currentColumn = 0;

        int count = 0;
        for (String row: forest) {
            if (row.charAt(currentColumn) == '#') {
                count++;
            }
            currentColumn = (currentColumn + 3) % columns;
        }

        return count;
    }
}
