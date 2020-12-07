import java.util.List;
import java.util.Map;

public class Task1 {
    public int countBags(Map<String, List<BagPair>> bags) {
        int count = 0;
        for (List<BagPair> value : bags.values()) { ;
            if (containsGoldBag(bags, value)) count++;
        }

        return count;
    }

    private boolean containsGoldBag(Map<String, List<BagPair>> bags, List<BagPair> contains) {
        if (contains.isEmpty()) return false;

        for (BagPair bagPair: contains) {
            if (bagPair.name.equals("shiny gold")) return true;
        }

        for (BagPair bagPair: contains) {
            if (containsGoldBag(bags, bags.get(bagPair.name))) return true;
        }

        return false;
    }
}
