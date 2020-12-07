import java.util.List;
import java.util.Map;

public class Task2 {
    public int countBags(Map<String, List<BagPair>> bags) {
        return recursiveCount(bags, bags.get("shiny gold"));
    }

    public int recursiveCount(Map<String, List<BagPair>> bags, List<BagPair> bagPairs) {
        int count = 0;
        if (bagPairs.isEmpty()) return count;
        for (BagPair bagPair: bagPairs) {
            count += bagPair.count;
            count += bagPair.count * recursiveCount(bags, bags.get(bagPair.name));
        }

        if (count == 0) System.out.println(bagPairs.get(0).name);
        return count;
    }
}
